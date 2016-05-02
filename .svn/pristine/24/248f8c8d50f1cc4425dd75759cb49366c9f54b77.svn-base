/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 * @author jayesh
 */
public class SendMailAttach {

	private JavaMailSender mailSender;

	public void sendMail(String from, String to, String subject, String msg,
			List<?> files) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(msg, true);

			// FileSystemResource file = new FileSystemResource("C:\\log.txt");

			if (null != files && !files.isEmpty()) {
				FileSystemResource file = null;
				Iterator<?> iter = files.iterator();
				while (iter.hasNext()) {
					file = new FileSystemResource((File) iter.next());
					helper.addAttachment(file.getFilename(), file);
				}
			}
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		mailSender.send(message);
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
}
