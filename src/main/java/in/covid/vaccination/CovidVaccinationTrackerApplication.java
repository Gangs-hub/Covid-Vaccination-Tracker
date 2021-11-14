package in.covid.vaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CovidVaccinationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidVaccinationTrackerApplication.class, args);
	}

}
