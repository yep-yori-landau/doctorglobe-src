package com.dg.data.service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

public class DistanceCalculatorService {

	private static final Logger logger = LoggerFactory
			.getLogger(DistanceCalculatorService.class);

	/**
	 * get distance by latitudes and longitudes
	 * 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @param unit
	 * @return distance
	 */
	public double getDistance(double lat1, double lon1, double lat2,
			double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
						* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		}
		else if (unit == "N") {
			dist = dist * 0.8684;
		}
		return Math.round(dist);
	}

	/**
	 * get flight hours
	 * @param distance
	 * @return flight hours
	 */
	public double getFlightHours(double distance) {
		double time = 0.0;
		int sec = (int) (3600 * distance / 500);
		int hours = (int) sec / 3600;
		int minutes = (sec % 3600) / 60;
		minutes = (int) (Math.round(minutes / 15.0) * 15.0);
		String timeString = hours + "." + minutes;
		time = Double.valueOf(timeString);
		return time;
	}

	/**
	 * get flight time
	 * @param distance
	 * @return flight time
	 */
	public String getFlightTime(double distance) {
		int sec = (int) (3600 * distance / 500);
		int hours = (int) sec / 3600;
		int minutes = (sec % 3600) / 60;
		minutes = (int) (Math.round(minutes / 15.0) * 15.0);
		String timeString = hours + " hr";
		if (minutes != 0) {
			if (minutes == 3) {
				minutes = 30;
			}
			if (minutes == 60) {
				timeString = ++hours + " hr ";
			}
			else {
				timeString = hours + " hr " + minutes + " min";
			}
		}
		return timeString;
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	/**
	 * get latitude and longitude by city
	 * 
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public String[] getLatLngByCity(String city) throws Exception {
		int responseCode = 0;
		String api = "http://maps.googleapis.com/maps/api/geocode/xml?address="
				+ URLEncoder.encode(city, "UTF-8") + "&sensor=true";
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url
				.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			;
			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String) expr.evaluate(document,
					XPathConstants.STRING);
			if (status.equals("OK")) {
				expr = xpath.compile("//geometry/location/lat");
				String latitude = (String) expr.evaluate(document,
						XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				String longitude = (String) expr.evaluate(document,
						XPathConstants.STRING);
				return new String[] { latitude, longitude };
			}
			else {
				throw new Exception(
						"Error from the API - response status: " + status);
			}
		}
		return null;
	}
}