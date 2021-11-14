package in.covid.vaccination.repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import in.covid.vaccination.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

	@Query("SELECT ci.citizenId  FROM Citizen ci WHERE ci.citizenAadharNo=:aaId")
	public Integer aadharExists(Integer aaId);
	
	
	//1.With Object[] array List
	@Query("SELECT ci.citizenEmailId,ci.citizenVaccinedate FROM Citizen ci WHERE ci.citizenDoses='First Dose' AND ci.mailFlag=0")
	public List<Object[]> getFirstVaccineDate();
	
	@Modifying  //For Insert,Update Delete and DDL statements
	@Query("UPDATE Citizen ci SET ci.mailFlag=1 WHERE ci.citizenEmailId=:eId")
	public Integer updateEmailFlag(String eId);
	
	
	//2.With Object[] array
	//@Query("SELECT ci.citizenEmailId,ci.citizenVaccinedate FROM Citizen ci WHERE ci.citizenDoses='First Dose' AND ci.mailFlag=0")
	//public List<Citizen> getFirstVaccineDate();
	
	

}
