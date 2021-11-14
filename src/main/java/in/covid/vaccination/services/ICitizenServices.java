package in.covid.vaccination.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.covid.vaccination.model.Citizen;

public interface ICitizenServices {
	
	/*1.save citizens
	 *2.Get all citizens 
	 *3.Get citizen by by id
	 *4.Get by Aadhar no.
	 *5.Delete citizen
	 *6.update citizen
	 */
	
	public Integer saveCitizen(Citizen czen);
	public List<Citizen> getAllCitizen();
	
	public Citizen getCitizenById(Integer id);
	
	public Citizen getCitizenByAadhar(Integer aaId);
	public void deleteCitizenById(Integer id);
	
	//public void deleteCitizenByAadhar(Integer aaId);
	//public void updateCitizenByid(Integer id);
	
	public void updateCitizen(Citizen czen);  //PUT update
	
	//Return list of employess on Page 
	public Page<Citizen> getAllCitizen(Pageable pageable);
	
	

}
