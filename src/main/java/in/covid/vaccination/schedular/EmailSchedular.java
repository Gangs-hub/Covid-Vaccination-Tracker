package in.covid.vaccination.schedular;


import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;




import in.covid.vaccination.mailservice.ReminderEmail;

import in.covid.vaccination.repo.CitizenRepository;
import in.covid.vaccination.utils.DateCalculator;
import lombok.extern.slf4j.Slf4j;




@Component
@Transactional
@Slf4j
public class EmailSchedular {

	//Log4j generate at class level
	//	private static final Logger log = (Logger) LoggerFactory.logger(EmailSchedular.class);

	@Autowired
	private CitizenRepository repot;
	@Autowired
	private ReminderEmail email;
	@Autowired
	private DateCalculator secondDate;

	@Value("${email.subject}") 
	String subject;
	@Value("${email.body}")
	String emailBody;

	//Testing 
	@Scheduled(cron=" 0 */1 * * * * ")  
	//@Scheduled(cron=" 0 0 10 * * ? ")
	public void getDetailsAndSendEmail(){
		Date firstVaccineDate=null;
		String secondVaccineDate=null;
		String emailId;
		Integer emailFlagUpdate;

		List<Object[]> data = repot.getFirstVaccineDate();


		if(data!=null && data.size()>0) {
			for (Object obj : data) {
				Object[] arr = (Object[]) obj;

				emailId=(String) arr[0];
				firstVaccineDate=(Date) arr[1];

				secondVaccineDate=secondDate.secondVaccineDate(firstVaccineDate);
				emailBody=emailBody.replaceAll("<Date>", secondVaccineDate);

				boolean sent = email.send(emailId, subject, emailBody);
				log.info("Email Status!"+sent);
				if (sent) {
					System.out.println("Email sent! Check in box");

					emailFlagUpdate=repot.updateEmailFlag(emailId);
					System.out.println("Flag Updated successfully!"+emailFlagUpdate);
					log.info("Email Flag Updated successfully!"+emailFlagUpdate);

				} else {
					System.out.println("Mail not sent!");
					log.error("Something went wrong! Mail not sent.");

				}
			}

		}else {
			
			System.out.println("Today no Emails for sending!");
			log.info("Today no Emails for sending!");
		}
	}
}





