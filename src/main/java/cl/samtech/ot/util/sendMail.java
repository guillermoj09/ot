package cl.samtech.ot.util;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;


public class sendMail {
	final static Logger logger = Logger.getLogger(sendMail.class);
	public static void enviarCorreo(String Subject,String Mensage, String to,String adj,String nombretecnico)  {
		StringWriter errors = new StringWriter();
		Properties p = new Properties();
		try {
			p.load(new FileReader("/opt/configg.properties"));
			//p.load(new FileReader("C:\\config-properties\\config.properties"));
			
		} catch (Exception e) {
			e.printStackTrace(new PrintWriter(errors));
        	logger.error("Error al enviar correo=" + errors.toString());
		}
		final String Username=p.getProperty("Username");
		final String PassWord=p.getProperty("PassWord");
		String From=p.getProperty("From");
		String To=to;
		String SmtpServer=p.getProperty("SmtpServer");
		String port=p.getProperty("port");	
		
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", SmtpServer);
	    props.put("mail.smtp.port", port);

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(Username, PassWord);
	                }
	            });

	    try {	
	    	Date date = new Date();
	    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	
            BodyPart texto = new MimeBodyPart();
            String ruta = "http://app.samtech.cl/web/imgotsamtech/";
            String rootpath = "/opt/tomcat/apache-tomcat-9.0.2/webapps/web/imgotsamtech/";
			//String rootpath = "C:\\Users\\aguil\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\otsamtech\\resources\\imagenes\\";

            texto.setText((new StringBuilder(String.valueOf(Mensage))).append("\n \n")
            		.append("Se adjunta comprobante con el detalle del trabajo finalizado por "+nombretecnico+" el día "+dateFormat.format(date)+". ").append("\n \n")
            		.append("ESTE ES UN MENSAJE GENERADO AUTOMATICAMENTE, POR FAVOR NO CONTESTAR. "
            				+ "Si tiene alguna duda respecto a la información contenida en este correo"
            				+ " o al trabajo realizado por "+nombretecnico+", por favor comunicarse al (562) 2898 8900.").append("\n")
            		.append("Saludos cordiales, \n \n ")
            		.append(ruta).append(adj).toString());
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(rootpath+adj)));
            //localhost
            //adjunto.setDataHandler(new DataHandler(new FileDataSource("C:\\pdfs\\"+adj)));
            adjunto.setFileName(adj);
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(From));
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setContent(multiParte);
            Transport.send(message);

	    } catch (MessagingException e) {
	    	e.printStackTrace(new PrintWriter(errors));
        	logger.error("Error al enviar correo=" + errors.toString());
	    }
	}
		
}


