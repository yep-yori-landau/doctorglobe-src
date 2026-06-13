package com.dg.patient.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/**
 * Mail Service
 * @author DoctorGlobe
 *
 */
@Service("mailService")
public class MailService {
	private static final Logger logger = LoggerFactory
			.getLogger(MailService.class);

	private SearchUrlService searchUrlService;

	private String mailFrom;

	/**
	 * Get Search Url Service
	 * @return SearchUrlService
	 */
	public SearchUrlService getSearchUrlService() {
		return this.searchUrlService;
	}

	/**
	 * Set SearchUrlService
	 * @param searchUrlService
	 */
	public void setSearchUrlService(SearchUrlService searchUrlService) {
		this.searchUrlService = searchUrlService;
	}

	/**
	 * Get Email Sender email id
	 * @return string 
	 */
	public String getMailFrom() {
		return this.mailFrom;
	}

	/**
	 * Set Email sender email id 
	 * @param mailFrom
	 */
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;

	/**
	 * Set mail sender
	 * @param mailSender
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * get Email sender
	 * @return JavaMailSender
	 */
	public JavaMailSender getMailSender() {
		return this.mailSender;
	}

	/**
	 * Send email function
	 * @param to the receiver email id
	 * @param subject the subject of email
	 * @param msg the message of email
	 * @param template the email template
	 * @param id the unique id of sender
	 * @param name the receiver name
	 * @param sender the sender email
	 * @param patient the boolean value true if receiver is patient
	 * @param practitioner the boolean value true if receiver is practitioner
	 */
	public void sendMail(String to, String subject, String msg, String template,
			Integer id, String name, String sender, boolean patient,
			boolean practitioner) {
		try {
			final Context context = new Context(
					LocaleContextHolder.getLocale());
			context.setVariable("name", name);
			context.setVariable("message", msg.replaceAll("[\n\r]+", "<br/>"));
			context.setVariable("sender", sender);
			context.setVariable("subject", subject);
			context.setVariable("imageResourceUrl",
					this.getSearchUrlService().getImageResourceUrl());
			if (id != null && !patient && !practitioner) {
				context.setVariable("url",
						this.getSearchUrlService().getCustomerMailUrl()
								+ "/active/id/" + id);
			}
			if (id != null && patient) {
				context.setVariable("url",
						this.getSearchUrlService().getPatientMailUrl() + id);
			}
			if (id != null && practitioner) {
				context.setVariable("url",
						this.getSearchUrlService().getPractitionerMailUrl() + id
								+ "&msg=1");
			}
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
					"UTF-8");
			message.setFrom(this.getMailFrom());
			message.setTo(to);
			message.setSubject(subject);
			final String htmlContent = this.templateEngine.process(template,
					context);
			message.setText(htmlContent, true);
			this.mailSender.send(mimeMessage);
		}
		catch (Exception ex) {
			logger.info(ex.getMessage());
		}
	}

	/**
	 * Send Password reset email
	 * @param to the receiver email id
	 * @param subject the subject of email
	 * @param msg the message of email
	 * @param template the email template
	 * @param id the unique id of sender
	 * @param name the receiver name
	 * @param pass the encoded password
	 * @param type the user type
	 * @param currentUrl the user current logged url
	 */
	public void sendResetMail(String to, String subject, String msg,
			String template, Integer id, String name, String pass, String type,
			String currentUrl) {
		try {
			final Context context = new Context(
					LocaleContextHolder.getLocale());
			context.setVariable("name", name);
			context.setVariable("message", msg.replaceAll("[\n\r]+", "<br/>"));
			context.setVariable("subject", subject);
			context.setVariable("imageResourceUrl",
					this.getSearchUrlService().getImageResourceUrl());
			if (id != null) {
				context.setVariable("url", currentUrl + "/reset?r=" + id + "&p="
						+ pass + "&type=" + type);
			}
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
					"UTF-8");
			message.setFrom(this.getMailFrom());
			message.setTo(to);
			message.setSubject(subject);
			final String htmlContent = this.templateEngine.process(template,
					context);
			message.setText(htmlContent, true);
			this.mailSender.send(mimeMessage);
		}
		catch (Exception ex) {
			logger.info(ex.getMessage());
		}
	}

	/**
	 * Send Conference email
	 * @param to the receiver email id
	 * @param subject the subject of email
	 * @param msg the message of email
	 * @param template the email template
	 * @param id the unique id of sender
	 * @param name the receiver name
	 * @param sender the sender name
	 * @param conference_dt the conference date
	 * @param patient the boolean value true if receiver is patient
	 * @param practitioner the boolean value true if receiver is practitioner
	 */
	public void sendConferenceMail(String to, String subject, String msg,
			String template, Integer id, String name, String sender,
			String conference_dt, boolean patient, boolean practitioner) {
		try {
			final Context context = new Context(
					LocaleContextHolder.getLocale());
			context.setVariable("name", name);
			context.setVariable("message", msg.replaceAll("[\n\r]+", "<br/>"));
			context.setVariable("sender", sender);
			context.setVariable("subject", subject);
			context.setVariable("conference_dt", conference_dt);
			context.setVariable("imageResourceUrl",
					this.getSearchUrlService().getImageResourceUrl());
			if (id != null && !patient && !practitioner) {
				context.setVariable("url",
						this.getSearchUrlService().getCustomerMailUrl()
								+ "/active/id/" + id);
			}
			if (id != null && patient) {
				context.setVariable("url",
						this.getSearchUrlService().getPatientMailUrl() + id);
			}
			if (id != null && practitioner) {
				context.setVariable("url",
						this.getSearchUrlService().getPractitionerMailUrl() + id
								+ "&msg=1");
			}
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
					"UTF-8");
			message.setFrom(this.getMailFrom());
			message.setTo(to);
			message.setSubject(subject);
			final String htmlContent = this.templateEngine.process(template,
					context);
			message.setText(htmlContent, true);
			this.mailSender.send(mimeMessage);
		}
		catch (Exception ex) {
			logger.info(ex.getMessage());
		}
	}

	/**
	 * Send Interview Request Registered email
	 * @param to the receiver email id
	 * @param subject the subject of email
	 * @param template the email template
	 * @param pc the unique id of patient case
	 * @param name the name of receiver
	 * @param doctorName the selected doctor name
	 * @param hospitalName the selected hospital name
	 * @param treatmentName the selected treatment name
	 */
	public void sendInterviewRequestRegisteredMail(String to, String subject,
			String template, Integer pc, String name, String doctorName,
			String hospitalName, String treatmentName) {
		try {
			final Context context = new Context(
					LocaleContextHolder.getLocale());
			context.setVariable("name", name);
			context.setVariable("doctorName", doctorName);
			context.setVariable("hospitalName", hospitalName);
			context.setVariable("treatmentName", treatmentName);
			context.setVariable("subject", subject);
			context.setVariable("imageResourceUrl",
					this.getSearchUrlService().getImageResourceUrl());
			context.setVariable("url",
					this.getSearchUrlService().getPatientMailUrl() + pc);

			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
					"UTF-8");
			message.setFrom(this.getMailFrom());
			message.setTo(to);
			message.setSubject(subject);
			final String htmlContent = this.templateEngine.process(template,
					context);
			message.setText(htmlContent, true);
			this.mailSender.send(mimeMessage);
		}
		catch (Exception ex) {
			logger.info(ex.getMessage());
		}
	}
}