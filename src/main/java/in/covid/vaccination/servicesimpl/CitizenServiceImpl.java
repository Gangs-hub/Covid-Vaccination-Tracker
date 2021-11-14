package in.covid.vaccination.servicesimpl;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.covid.vaccination.model.Citizen;
import in.covid.vaccination.repo.CitizenRepository;
import in.covid.vaccination.services.ICitizenServices;
import lombok.extern.slf4j.Slf4j;

@Service

public class CitizenServiceImpl implements ICitizenServices {

	@Autowired
	private CitizenRepository repo;

	@Override
	public Integer saveCitizen(Citizen czen) {

		return repo.save(czen).getCitizenId();
		
	}

	@Override
	public List<Citizen> getAllCitizen() {
		List<Citizen> list=repo.findAll();
		return list;
	}
	
	@Override
	public Page<Citizen> getAllCitizen(Pageable pageable) {
		
		return repo.findAll(pageable);
	}
	
	@Override
	public Citizen getCitizenById(Integer id) {
		Optional<Citizen>opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}

	@Override  //Integer validation
	public Citizen getCitizenByAadhar(Integer aaId) {

		Integer id=repo.aadharExists(aaId);
		
		if(id!=null) {
	
		Optional<Citizen>opt=repo.findById(id);

		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
		}
		return null;
	}

	
	

	@Override
	public void updateCitizen(Citizen czen) {
		repo.save(czen);
	}

	@Override
	public void deleteCitizenById(Integer id) {
		repo.deleteById(id);
		
	}

	

	

}
