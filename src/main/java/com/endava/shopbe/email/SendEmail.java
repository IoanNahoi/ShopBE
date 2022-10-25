package com.endava.shopbe.email;

import lombok.NoArgsConstructor;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@NoArgsConstructor
public class SendEmail {

    public void SendAnEmail(String toEmail, String subject, String text) {
        Logger logger = Logger.getLogger(SendEmail.class.getName());
        String from = "r3pyku98@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "bziryfxilnbkbiog");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(text);
            logger.log(Level.INFO, "Functie");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void RegisterSendEmail(String toEmail) {
        String subject = "Registration confirmation!";
        String text = "Hello!\n Your account has been succesfully created! You can now have acces to our platform! \nGood luck and have fun!";
        SendAnEmail(toEmail, subject, text);
    }
}
