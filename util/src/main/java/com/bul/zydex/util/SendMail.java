/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.core.io.FileSystemResource;
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

//        if(to.contains("spcls.co.in")){
//        helper.setFrom(from);
        helper.setFrom("myspc@spcls.co.in");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(msg, true);

        try {
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Mail Exception :-" + e);

        }
//        }else{

//        }
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
    public void sendMailofferLetter(String from, String to, String subject, String msg, String filename, String employeeName, List<?> files) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        Multipart multipart = new MimeMultipart("alternative");

//		SimpleMailMessage message = new SimpleMailMessage();
//        mimeMessage.setContent(msg, "text/html");
//        mimeMessage.setFileName(filename);
//        if(to.contains("spcls.co.in")){
//        helper.setFrom(from);
        helper.setFrom("myspc@spcls.co.in");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(msg.replaceAll("\\<[^>]*>", "").replaceAll("&nbsp;", " ").replaceAll("&amp;", "&"));

        Object[] arrayOfObject;

        if (null != files && !files.isEmpty()) {
            FileSystemResource file = null;
            for (Object finicialyearList : files) {

                ArrayList al = (ArrayList) finicialyearList;
                String path = (String) al.get(0);
                String name = (String) al.get(1);

//                Object[] o = (Object[]) finicialyearList;
                File file1 = new File(path);

                file = new FileSystemResource((File) file1);
//                helper.addAttachment(file.getFilename(), file);

                DataSource source = new FileDataSource(path);
                BodyPart messageBodyPart = new MimeBodyPart();

                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(name);

                MimeBodyPart textBodyPart = new MimeBodyPart();
                textBodyPart.setText(msg.replaceAll("\\<[^>]*>", "").replaceAll("&nbsp;", " ").replaceAll("&amp;", "&"));
//                messageBodyPart.setText(msg);
                multipart.addBodyPart(textBodyPart);
                multipart.addBodyPart(messageBodyPart);

                mimeMessage.setContent(multipart);

                helper.addAttachment(name, source);

//                
            }

//            for (Iterator<? extends Object> it = files.iterator(); it.hasNext();) {
//                arrayOfObject = (Object[]) it.next();
//                FileSystemResource file = null;
//                Iterator<?> iter = files.iterator();
//                while (iter.hasNext()) {
//                    file = new FileSystemResource((File) arrayOfObject[0]);
//                    helper.addAttachment(file.getFilename(), file);
//                }
//
//            }
//				
        }

        try {
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            System.out.println("Mail Exception :-" + e);

        }
//        }else{

//        }
    }

    
    
    
}
