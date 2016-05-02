/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author Jayesh
 */
public class SendMail {

    private JavaMailSender mailSender;

    public void sendMail(String from, String to, String subject, String msg) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//		SimpleMailMessage message = new SimpleMailMessage();
        mimeMessage.setContent(msg, "text/html");

        if(to.contains("zydexindustries.com")){
            
//        helper.setFrom(from);
        helper.setFrom("ecafe@zydexindustries.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(msg, true);

        try {
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Mail Exception :-" + e);

        }
        }else{
            
        }
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

//	private MailSender mailSender;
//
//	public void sendMail(String from, String to, String subject, String msg) {
//
//		SimpleMailMessage message = new SimpleMailMessage();
//
//		message.setFrom(from);
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(msg);
//
//		mailSender.send(message);
//	}
//
//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
}
