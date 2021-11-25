package com.konark.basky.utils;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Component
public class Email {
    Properties props = new Properties();
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("ninja.hatori.hareela@gmail.com", "adityasharma123");
        }
    });


    public boolean sendEmail(String username, String password,String email) throws AddressException, MessagingException, IOException {
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress("konarksharma644@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Login Credentials");
        msg.setContent("Your Login Credentials are \n Username:- " + username + "\n Password:- "+ password  , "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
        return true;
    }


}