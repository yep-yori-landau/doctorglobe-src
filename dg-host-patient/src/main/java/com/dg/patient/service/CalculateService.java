package com.dg.patient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dg.patient.model.EmployeeCorporatecompanyDetailModel;

public class CalculateService {

	private static final Logger logger = LoggerFactory
			.getLogger(CalculateService.class);

	/**
	 * Get you pay up to price
	 * @param model
	 * @param origin_price
	 * @return double
	 */
	public Double getYouPayUpTo(EmployeeCorporatecompanyDetailModel model,
			Double origin_price) {
		/*
		 * logger.info("calculate you pay up to"); logger.info(
		 * "origin price  ={}",origin_price); logger.info("deductible ={}"
		 * ,model.getCorporatecompanyDeductible()); logger.info("annualoop ={}"
		 * ,model.getCorporatecompanyAnnualOop()); logger.info(
		 * "corporatecompany isurance ={}"
		 * ,model.getCorporatecompanyCoInsurance()); logger.info("ytd oop ={}"
		 * ,model.getYtdOop());
		 */
		Double worker_max_payment = 0.0;
		Double left_to_pay_for_deductible = 0.0;
		Double left_for_origin_price = 0.0;
		if (model.getYtdOop() >= model.getCorporatecompanyDeductible()) {
			worker_max_payment = Math.min(
					(origin_price * model.getCorporatecompanyCoInsurance())
							/ 100,
					model.getCorporatecompanyAnnualOop() - model.getYtdOop());
		}
		else {
			left_to_pay_for_deductible = model.getCorporatecompanyDeductible()
					- model.getYtdOop();
			if (origin_price > left_to_pay_for_deductible) {
				left_for_origin_price = origin_price
						- left_to_pay_for_deductible;
				worker_max_payment = left_to_pay_for_deductible + Math.min(
						(left_for_origin_price
								* model.getCorporatecompanyCoInsurance()) / 100,
						model.getCorporatecompanyAnnualOop()
								- model.getCorporatecompanyDeductible());
			}
			else {
				worker_max_payment = origin_price;
			}
		}
		if (worker_max_payment < 0) {
			worker_max_payment = 0.0;
		}
		// logger.info("you pay up to ={}",worker_max_payment);
		return worker_max_payment;
	}

	/**
	 * Get you get up to price
	 * @param model
	 * @param origin_price
	 * @param you_pay_up_to
	 * @return double
	 */
	public Double getYouGetUpTo(EmployeeCorporatecompanyDetailModel model,
			Double origin_price, Double you_pay_up_to,
			Double destination_cost) {
		/*
		 * logger.info("calculate you get up to"); logger.info(
		 * "origin price in calculate service ={}",origin_price); logger.info(
		 * "you pay up to in calculate service ={}",you_pay_up_to); logger.info(
		 * "worker_incentive in calculate service ={}"
		 * ,model.getWorkerIncentive());
		 */
		Double you_get_up_to = 0.0;
		you_get_up_to = (origin_price - you_pay_up_to - destination_cost)
				* model.getWorkerIncentive() / 100;
		if (you_get_up_to < 0) {
			you_get_up_to = 0.0;
		}
		// logger.info("you get up to in calculate service ={}",you_get_up_to);
		return this.getRoundValue(you_get_up_to, 100);
	}

	/**
	 * Check hospital is available to display
	 * @param model
	 * @param origin_price
	 * @param worker_max_payment
	 * @return boolean
	 */
	public Boolean getHospitalIsAvailable(
			EmployeeCorporatecompanyDetailModel model, Double origin_price,
			Double worker_max_payment, Double destination_cost) {
		/*
		 * logger.info("check hospital available"); logger.info(
		 * "mimimum percentage spread ={}",model.getMinimumPercentageSpread());
		 * logger.info("dg commission ={}",model.getDgCommission());
		 * logger.info("destination cost ={}",destination_cost); logger.info(
		 * "origin_price ={}",origin_price); logger.info(
		 * "worker_max_payment ={}",worker_max_payment);
		 */
		Boolean result = false;
		Double employer_cost_at_origin = 0.0;
		Double EMPS_amount = 0.0;
		Double origin_destination_spread = 0.0;
		Double dg_commission = 0.0;
		Double worker_reward = 0.0;
		Double employer_saving = 0.0;

		employer_cost_at_origin = origin_price
				- worker_max_payment; /*
										 * Employer cost is the actual cost minus
										 * worker share
										 */
		// logger.info("employer_cost_at_origin ={}",employer_cost_at_origin);
		EMPS_amount = employer_cost_at_origin
				* model.getMinimumPercentageSpread()
				/ 100; /*
						 * The value of the minimum discounted percentage
						 * requested by employer
						 */
		// logger.info("EMPS_amount ={}",EMPS_amount);
		/*
		 * The below should be done for each doctor in each hospital
		 * (Destination cost is the doctor cost within the destination hospital
		 * A hospital is shown if at least one of its doctor is shown
		 */
		origin_destination_spread = employer_cost_at_origin - destination_cost;
		// logger.info("origin_destination_spread
		// ={}",origin_destination_spread);
		if (origin_destination_spread > 0) { /*
												 * We care only about hospitals
												 * with lower total cost for
												 * employer than origin cost
												 */
			if (origin_destination_spread >= EMPS_amount) { /*
															 * Is saving larger
															 * or equal to the
															 * minimum
															 * percentage set by
															 * employer
															 */
				dg_commission = origin_destination_spread
						* model.getDgCommission() / 100;
				worker_reward = origin_destination_spread
						* model.getWorkerIncentive() / 100;
				employer_saving = origin_destination_spread - dg_commission
						- worker_reward;
				if (employer_saving >= model.getMinimumAmountSpread()
						&& employer_saving >= EMPS_amount) { /*
																 * final employer
																 * saving should
																 * be larger
																 * than both,
																 * requested
																 * amount and
																 * requested %
																 */
					result = true;
				}
			}
		}
		// logger.info("hospital or practitoner available calculate service
		// ={}",result);
		return result;
	}

	/**
	 * Gets the rounded value
	 * @param input 
	 * @param toNearest
	 * @return Double
	 */
	public Double getRoundValue(double input, double toNearest) {
		// toNearest is any rounding base like 10, 100 or 1000.
		double modValue = input % toNearest;
		double roundedValue;
		System.out.println(modValue);
		if (modValue == 0) {
			roundedValue = input;
		}
		else {
			roundedValue = ((input - modValue) + toNearest);
		}
		return roundedValue;
	}

}