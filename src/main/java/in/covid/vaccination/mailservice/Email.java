package in.covid.vaccination.mailservice;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	
	private String emailId;
	private Date vaccineDate;

	
}
