package com.dg.patient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opentok.OpenTok;
import com.opentok.Role;
import com.opentok.Session;
import com.opentok.TokenOptions;
import com.opentok.exception.OpenTokException;

public class OpentokService {

	private static final Logger logger = LoggerFactory
			.getLogger(OpentokService.class);

	private String apiKey;

	private String apiSecret;

	private static OpenTok opentok;

	private static String sessionId;

	private static String token;

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public OpenTok getOpenTok() {
		try {
			if (apiKey == null || apiKey.isEmpty() || apiSecret == null
					|| apiSecret.isEmpty()) {
				logger.info("opentok api key not found");
				return null;
			}
			else {
				opentok = new OpenTok(Integer.parseInt(this.getApiKey()),
						this.getApiSecret());
				return opentok;
			}
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		return null;
	}

	public String getSessionId() throws OpenTokException {
		try {
			Session session = this.getOpenTok().createSession();
			sessionId = session.getSessionId();
		}
		catch (Exception ex) {
			logger.info("exception found {}", ex.getMessage());
		}
		return sessionId;
	}

	public String getToken() throws OpenTokException {
		/*
		 * String connectionMetadata = "username=Bob,userLevel=4"; TokenOptions
		 * tokenOpts = new TokenOptions.Builder() .role(Role.MODERATOR)
		 * .expireTime((System.currentTimeMillis() / 1000) + (1 * 24 * 60 * 60))
		 * .data(connectionMetadata) .build();
		 */
		token = this.getOpenTok().generateToken(this.getSessionId());
		return token;
	}
}