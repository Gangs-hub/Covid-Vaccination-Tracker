package in.covid.vaccination.mailservice;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReminderEmail {
	
	@Autowired
	private JavaMailSender sender;
	
	public boolean send(
			String to,
			String subject,
			String body
			) {
		
		boolean mailsent=false;
		
		try {
		//Create Mimemessage
		MimeMessage message=sender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			
			sender.send(message);
			mailsent=true;
			
			
			
			
		} catch (MessagingException e) {
		
		//	e.printStackTrace();
			log.error("Oops",e);
			mailsent=false;
		}
		
			return mailsent;
		
	}
	
	

}
