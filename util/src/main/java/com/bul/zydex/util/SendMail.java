/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.*;  
import javax.mail.Authenticator;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author Jayesh
 */
public class SendMail {
    List toS;
    String toList = "";
    public List getToS() {
        return toS;
    }

    public void setToS(List toS) {
        this.toS = toS;
        Iterator itr = toS.iterator();
        while(itr.hasNext()){
            toList +=","+itr.next();
        }
    }
    private JavaMailSender mailSender;

    public void sendMail(String from, String to, String subject, String msg) throws MessagingException {

        
        String ip="";
        String port="";
        String user_name="";
        String password="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eprocsuite_chargezone","root","root");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from smtp_details");  
            while(rs.next()) 
            {
                port = rs.getString(2);
                user_name = rs.getString(3);
                password = rs.getString(4);
                ip = rs.getString(6);
                
            }
            con.close();  
        }catch(Exception e111){}
        
        
      
            String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

            Properties props = new java.util.Properties();

            props.put("mail.smtp.auth", "true");

            props.put("mail.smtp.starttls.enable", "true");

            props.put("mail.smtp.host", ip);

            props.put("mail.smtp.port", port);

            props.put("mail.debug", "true");

            props.put("mail.debug.auth", "true");

        //    props.put("mail.smtp.auth.xoauth2.disable", "false");

         //   props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            props.put("mail.transport.protocol", "smtp");

        //    props.put("mail.smtp.auth.login.disable", "true");

         //   props.put("mail.smtp.auth.plain.disable", "true");

            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            
            final String EmailUser = user_name;
            final String EmailPassword = password;

            Session session = javax.mail.Session.getInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(EmailUser, EmailPassword);

            }

            });

            try
            {
                
                MimeMessage l_msg = new MimeMessage(session); // Create a New message
            l_msg.setFrom(new InternetAddress(user_name)); // Set the From address
            l_msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));  
            l_msg.setSubject(subject); // Sets the Subject
            MimeBodyPart l_mbp = new MimeBodyPart();
            l_mbp.setText(msg);
            Multipart l_mp = new MimeMultipart();
            l_mp.addBodyPart(l_mbp);
            l_msg.setContent(msg, "text/html");
            l_msg.setSentDate(new java.util.Date());
//            Transport.send(l_msg);
             }catch(Exception e11){
                System.out.println(e11);
            }
        /*    try
            {
            Transport transport = session.getTransport("smtp");

            transport.connect(user_name, "gbdxzqjztdwgxzys");

            MimeMessage message=new MimeMessage(session);

            message.setFrom(new InternetAddress(user_name));

            message.addRecipient(Message.RecipientType.TO,

            new InternetAddress("tailorsamir@gmail.com"));

            message.setText("aa");

            Transport.send(message);
            }catch(Exception e11){
                System.out.println(e11);
            } */
       
        
        /*
        
     //   to = "tailorsamir@gmail.com";
        String l_host = ip;
        // Gets the System properties
        Properties l_props = new Properties();
        // Puts the SMTP server name to properties object
        l_props.put("mail.smtp.auth", "true");
                l_props.put("mail.smtp.host", ip);
                l_props.put("mail.smtp.port", port);
            //    l_props.put("mail.smtp.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
                l_props.put("mail.smtp.starttls.enable", "true");
             //   l_props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                  //  	l_props.put("mail.smtp.starttls.required", "true");
                    //	l_props.put("mail.smtp.auth", "true");
                     //       l_props.put("mail.smtp.ssl.trust", "mail.gfl.co.in");
                l_props.put("mail.smtp.ssl.trust", ip);
                
                l_props.put("mail.debug", "true");
        l_props.put("mail.transport.protocol", "smtp");
        l_props.put("mail.smtp.ssl.enable", "true");
                
	l_props.put("mail.smtp.connectiontimeout", "10000");
	
//Session l_session = Session.getInstance(l_props, null);
        final String EmailUser = user_name;
	final String EmailPassword = password;

	Session l_session = Session.getInstance(l_props, new javax.mail.Authenticator() {
			  protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
					EmailUser,EmailPassword);
			     }
		   });


        l_session.setDebug(false); // Enable the debug mode
        try {
            MimeMessage l_msg = new MimeMessage(l_session); // Create a New message
            l_msg.setFrom(new InternetAddress(user_name)); // Set the From address
            l_msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));  
            l_msg.setSubject(subject); // Sets the Subject
            MimeBodyPart l_mbp = new MimeBodyPart();
            l_mbp.setText(msg);
            Multipart l_mp = new MimeMultipart();
            l_mp.addBodyPart(l_mbp);
            l_msg.setContent(msg, "text/html");
            l_msg.setSentDate(new java.util.Date());
            Transport.send(l_msg);
        } catch (MessagingException mex) { // Trap the MessagingException Error
        java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());

        //C1.edit("insert into msg_failure (id, from1, to1, subject1, reason,date) values (0,'"+p_from+"','"+mail_to+"','"+p_subject+"','"+res+"','"+sqlDate+"')");
        //out.print("Failure: Messaging Exception: " + mex);
        } catch (Exception e) {
        java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        //C1.edit("insert into msg_failure (id, from1, to1, subject1, reason) values (0,'"+p_from+"','"+mail_to+"','"+p_subject+"','"+res+"','"+sqlDate+"')");
        //out.print("Failure: General Exception: " + e);
        e.printStackTrace();
        } */
       /* 
       // try
       // {
            String l_host = "mail.gfl.co.in";
            Properties l_props = new Properties();


            l_props.put("mail.smtp.auth", "true");
                l_props.put("mail.smtp.host", "mail.gfl.co.in");
                l_props.put("mail.smtp.port", "587");
             //   l_props.put("mail.smtp.starttls.enable", "true");
                    //	l_props.put("mail.smtp.starttls.required", "true");
                    //	l_props.put("mail.smtp.auth", "true");
                            l_props.put("mail.smtp.ssl.trust", "mail.gfl.co.in");


            Session l_session = Session.getInstance(l_props,
              new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("vendor.portal@gfl.co.in","Vp#@753@#");
              }
            }); 

            l_session.setDebug(false); // Enable the debug mode
            MimeMessage l_msg = new MimeMessage(l_session); // Create a New message
            l_msg.setFrom(new InternetAddress("vendor.portal@gfl.co.in")); // Set the From address
            l_msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));  
            l_msg.setSubject(subject); // Sets the Subject
            MimeBodyPart l_mbp = new MimeBodyPart();
            l_mbp.setText(msg);
            Multipart l_mp = new MimeMultipart();
            l_mp.addBodyPart(l_mbp);
            l_msg.setContent(msg, "text/html");
            l_msg.setSentDate(new java.util.Date());
            Transport.send(l_msg);
        //}
        //catch(Exception e){} */
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
        helper.setFrom("pooja@vaderanco.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(msg.replaceAll("\\<[^>]*>", "").replaceAll("&nbsp;", " ").replaceAll("&amp;", "&").replaceAll("&#160", "&"));

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
