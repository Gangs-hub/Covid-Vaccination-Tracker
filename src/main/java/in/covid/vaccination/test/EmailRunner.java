package in.covid.vaccination.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.covid.vaccination.mailservice.ReminderEmail;

//@Component
public class EmailRunner implements CommandLineRunner {
	@Autowired
	private ReminderEmail email;
	
	/*
	 * @Value("${email.subject}") String subject;
	 * 
	 * @Value("${email.body}") String emailBody;
	 */

	
	public void run(String... args) throws Exception {
		

		String emailId =null;
		Date firstDate = null;

		String subject = "Covid Vaccination Reminder";
		String emailBody = "Dear Citizen, Your second vaccination is due on 16/01/2022";

		emailId = "rdoibale@gmail.com";
		// To, Subject,Body
		boolean sent = email.send(emailId, subject, emailBody);

		if (sent) {
			System.out.println("Check in box");
		} else {
			System.out.println("Mail not sent!");
		}


	}

}
