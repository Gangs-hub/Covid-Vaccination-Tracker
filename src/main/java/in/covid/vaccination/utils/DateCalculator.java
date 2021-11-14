package in.covid.vaccination.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateCalculator {
	
	
	public String secondVaccineDate(Date firstVaccineDate) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Calendar c =Calendar.getInstance();
		c.setTime(firstVaccineDate);
		c.add(Calendar.DATE, 89);
		return sdf.format(c.getTime());
		
	}
	
	

}
