package com.dg.doctor.service;


import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service("mailService")
public class MailService
{
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	  
	private SearchUrlService searchUrlService;
	
	private String mailFrom;
	  
	public SearchUrlService getSearchUrlService()
	{
		return this.searchUrlService;
	}
	  
	public void setSearchUrlService(SearchUrlService searchUrlService)
	{
		this.searchUrlService = searchUrlService;
	}
	
	public String getMailFrom(){
		return this.mailFrom;
	}
	
	public void setMailFrom(String mailFrom){
		this.mailFrom = mailFrom;
	}
	
	@Autowired
	private JavaMailSender mailSender;	
	
	@Autowired 
    private TemplateEngine templateEngine;
	
	public void setMailSender(JavaMailSender mailSender)
	{
		this.mailSender = mailSender;	
	}
	
	public JavaMailSender getMailSender()
	{
		return this.mailSender;
	}
	
	
	
	public void sendMail(String to,String subject, String msg,String template,String conference_dt,String name,String sender_name,Integer pc,boolean patient,boolean practitioner)
	{
		try{			
			final Context context = new Context(LocaleContextHolder.getLocale());
			context.setVariable("subject", subject);
			context.setVariable("name", name);
			context.setVariable("message", msg.replaceAll("[\n\r]+", "<br/>"));			
			context.setVariable("conference_dt", conference_dt);
			context.setVariable("sender_name", sender_name);
			context.setVariable("imageResourceUrl", this.getSearchUrlService().getImageResourceUrl());
			if(patient){
				context.setVariable("url", this.getSearchUrlService().getPatientMailUrl()+pc);
			}
			if(practitioner && pc == null){
				context.setVariable("url", this.getSearchUrlService().getPractitionerMailUrl()+"/home/index");
			}
			if(pc != null && practitioner){
				context.setVariable("url", this.getSearchUrlService().getPractitionerMailUrl()+"/home/view?"+pc+"&msg=1");
			}
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
			message.setFrom(this.getMailFrom());
			message.setTo(to);
			message.setSubject(subject);			
			final String htmlContent = this.templateEngine.process(template, context);
			message.setText(htmlContent,true);			
			this.mailSender.send(mimeMessage);		
		}catch(Exception ex){
			logger.info(ex.getMessage());
		}
	}	
	
	public void sendResetMail(String to,String subject, String msg,String template,Integer id,String name,String pass)
	{
		try{			
			final Context context = new Context(LocaleContextHolder.getLocale());
			context.setVariable("name", name);
			context.setVariable("message", msg.replaceAll("[\n\r]+", "<br/>"));
			context.setVariable("subject", subject);
			context.setVariable("imageResourceUrl", this.getSearchUrlService().getImageResourceUrl());
			if(id != null){
				context.setVariable("url", this.getSearchUrlService().getPractitionerMailUrl()+"/reset?r="+id+"&p="+pass);
			}			
			final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
			message.setFrom(this.getMailFrom());
			message.setTo(to);
			message.setSubject(subject);			
			final String htmlContent = this.templateEngine.process(template, context);
			message.setText(htmlContent,true);			
			this.mailSender.send(mimeMessage);		
		}catch(Exception ex){
			logger.info(ex.getMessage());
		}
	}
}