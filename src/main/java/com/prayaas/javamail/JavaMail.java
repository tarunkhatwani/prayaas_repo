package com.prayaas.javamail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.prayaas.pojos.Activitytable;
//import com.app.mail.JavaMail.SMTPAuthenticator;

public class JavaMail {
	private String d_email ="prayaasdemoproject@gmail.com";
	private String d_password="Group8project"; //your email password
    private String d_host = "smtp.gmail.com";
    private String d_port = "465";
    private String m_to; // Target email address
    private String m_subject = "Activity Details";
    private String m_text1 = "Hi there! \nYou have successfully registered for ";
    private String m_text2 = " . The activity starts at ";
    private String m_text3 = " . You are requested to be there on time. And the address is : ";
    private String m_text4 = "\n \nThank You.";
    private Activitytable activity=null;

	/**
	 * 
	 */
	public JavaMail() {
		// TODO Auto-generated constructor stub
	}
	public JavaMail(String m_to,Activitytable activity) {
    	this.m_to=m_to;
    	this.activity=activity;
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
        	System.out.println(m_to);
        	System.out.println(activity);
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);     
            MimeMessage msg = new MimeMessage(session);
            msg.setText(m_text1 + activity.getActivity_Name() + m_text2 + activity.getActivity_Time() + 
            		m_text3 + activity.getActivity_Address() + m_text4);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            System.out.println("Before Transference");
            Transport.send(msg);
            System.out.println("After Transference");
  	      
        } catch (Exception mex) {
        	
            mex.printStackTrace();
        }
      
	}
	public String getD_email() {
		return d_email;
	}
	public void setD_email(String d_email) {
		this.d_email = d_email;
	}
	public String getD_password() {
		return d_password;
	}
	public void setD_password(String d_password) {
		this.d_password = d_password;
	}
	public String getD_host() {
		return d_host;
	}
	public void setD_host(String d_host) {
		this.d_host = d_host;
	}
	public String getD_port() {
		return d_port;
	}
	public void setD_port(String d_port) {
		this.d_port = d_port;
	}
	public String getM_to() {
		return m_to;
	}
	public void setM_to(String m_to) {
		this.m_to = m_to;
	}
	public String getM_subject() {
		return m_subject;
	}
	public void setM_subject(String m_subject) {
		this.m_subject = m_subject;
	}
	/*public String getM_text() {
		return m_text;
	}
	public void setM_text(String m_text) {
		this.m_text = m_text;
	}*/
	public Activitytable getActivity() {
		return activity;
	}
	public void setActivity(Activitytable activity) {
		this.activity = activity;
	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }


}
