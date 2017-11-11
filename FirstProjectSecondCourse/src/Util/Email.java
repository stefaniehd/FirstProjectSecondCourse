/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author pc
 */
public class Email {

    private String subject;
    private String message;
    private String email;
    private String emailtTo;

    public Email() {
        email = "sr20neovvl2000@gmail.com";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailtTo() {
        return emailtTo;
    }

    public void setEmailtTo(String emailtTo) {
        this.emailtTo = emailtTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void send() {

        String USER_NAME = "sr20neovvl2000";  // GMail user name (just the part before "@gmail.com")
        String PASSWORD = "Vladi1234";
        // Sender's email ID needs to be mentioned
        String from = "sr20neovvl2000@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        String [] to = new String[1];
        to[0]= this.getEmailtTo();
        sendFromGMail(USER_NAME, PASSWORD, to, this.getSubject(), this.getMessage());
    }

    public void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {

            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");

            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
