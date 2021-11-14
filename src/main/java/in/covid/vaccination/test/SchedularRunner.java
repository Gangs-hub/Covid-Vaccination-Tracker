package in.covid.vaccination.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.covid.vaccination.mailservice.ReminderEmail;
import in.covid.vaccination.repo.CitizenRepository;
import in.covid.vaccination.utils.DateCalculator;

//@Component
public class SchedularRunner implements CommandLineRunner {

	@Autowired
	private CitizenRepository repot;
	@Autowired
	private DateCalculator secondDate;
	

	
	
	public void run(String... args) throws Exception {
		
		 Date firstVaccineDate=null;
		 String secondVaccineDate=null;

		// 1. With Object[] list
		/*
		 * repot.getFirstVaccineDate() .stream() .map(ob->ob[0]+","+ob[1])
		 * .forEach(System.out::println);
		 */

		List<Object[]> data = repot.getFirstVaccineDate();
		for (Object obj : data) {
			// System.out.println(Arrays.toString((Object[]) obj));
			// we directly cant print array need to assign to other array with same type
			Object[] arr = (Object[]) obj;
			System.out.println(arr[0]); // email ID
			System.out.println(arr[1]); // First vaccine Date
			
			firstVaccineDate=(Date) arr[1];
			
			System.out.println("Date is "+firstVaccineDate);
			secondVaccineDate=secondDate.secondVaccineDate(firstVaccineDate);
			
			System.out.println("Second vaccine date is "+secondVaccineDate);
			
			//To add 90 days or to add 3 months 
			
			

			

		}

	
		

	}
	

}
