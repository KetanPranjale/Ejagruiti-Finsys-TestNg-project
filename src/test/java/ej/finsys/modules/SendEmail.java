package ej.finsys.modules;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;

import ej.finsys.config.Config;
import ej.finsys.config.NormaliseParameters;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
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
import javax.mail.BodyPart;
import okhttp3.Protocol;


public class SendEmail {
	
	/**
	 * 
	 * @param fromEmailId -  fromemailid@tosendmail.com
	 * @param toEmailId   -  wheretosend@email.com
	 * @param LocalHost   -  smptp.gmail.com 
	 * @param port		  -   465 / 587 (see what works for you)
	 * @param fromEmailPassword - ****Password**** 
	 * @param attachmentDetails - location of attachment
	 * @param protocol			- smtp
	 * @throws IOException 
	 */

	public static void SendReportThroughEmail() throws IOException
	{
//		System.out.println("Starting of sending email report");
		String to = Config.getParameterValue("toEmailId");
		final String from = Config.getParameterValue("fromEmailId");
		String host = Config.getParameterValue("LocalHost");
		
		//---- Get system properties
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", Config.getParameterValue("protocol"));
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", Config.getParameterValue("port"));
		
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth",true);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Authenticator authenticator = new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				try {
					return new PasswordAuthentication(from,Config.getParameterValue("fromEmailPassword"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Email authentical failed");
					e.printStackTrace();
				}
				System.out.println("Returning null");
				return null;
			}
		};
		
		
		//---- get the default session object
		Session session = Session.getDefaultInstance(properties,authenticator);
		
		try{
			// default MimeMessage object
			MimeMessage message = new MimeMessage(session);
			
			// Set From: header field of the header
			message.setFrom(new InternetAddress(from));
			
			//set To: header field of the header
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// set subject: header field
			message.setSubject("Build for finsys has been completed");
			
			//create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			
			//fill the message
			messageBodyPart.setText("Build has been completed for finsys");
			
			//create a multipart message
			Multipart multiPart = new MimeMultipart();
			
			//set text message part
			multiPart.addBodyPart(messageBodyPart);
			
			//part two is attachment
			messageBodyPart = new MimeBodyPart();
			String fileName = NormaliseParameters.getParameterCompanyCreated("reportcreated");
			DataSource source = new FileDataSource(fileName);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multiPart.addBodyPart(messageBodyPart);
			
			//send the complete message parts
			message.setContent(multiPart);
			
			//send message
			Transport.send(message);
			System.out.println("email sent successfully");			
		}catch(MessagingException mex){
			mex.printStackTrace();
		}
	}
	
/*	public static void main(String args[]){
		SendReportThroughEmail("ketanpranjale86@gmail.com", "pranjale.ks@gmail.com", "smtp.gmail.com","465", "Nibru1312", "G:\\Finsys Reports\\finsys_test_report21Jul18065402.html", "smtp");
	}*/
}
