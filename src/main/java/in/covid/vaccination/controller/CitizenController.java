package in.covid.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.covid.vaccination.model.Citizen;
import in.covid.vaccination.servicesimpl.CitizenServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/citizen")
@Slf4j
public class CitizenController {

	@Autowired
	private CitizenServiceImpl serviceImp;


	//Just show registration page
	@GetMapping("/register")
	public String registerCitizen() {

		return "registrationForm";	
	}

	//Save operation for registration page
	@PostMapping("/save")
	public String saveCitizen(
			@ModelAttribute Citizen citizen,
			Model model
			) {
		citizen.setMailFlag(0);
		Integer id=	serviceImp.saveCitizen(citizen);
		String msg="Registration successfull! Your Id is "+id;
		log.info("Citizen has been registered Id "+id);
		model.addAttribute("message", msg);
		return "registrationForm";	
	}

	//Show all(Normal) registered Citizen
	/*
	 * @GetMapping("/all") public String showAll( Model model,
	 * 
	 * @RequestParam(required=false) String message ) {
	 * List<Citizen>list=serviceImp.getAllCitizen(); model.addAttribute("clist",
	 * list); model.addAttribute("message", message);
	 * 
	 * return "allCitizens"; }
	 */

	//Show all(Pageable) registered Citizen
	@GetMapping("/all")
	public String showAllPageable(Model model,
			@PageableDefault(page=0,size=5) Pageable pageable,
			@RequestParam(required = false) String message
			) {

		Page<Citizen> page=serviceImp.getAllCitizen(pageable);
		model.addAttribute("page", page);
		model.addAttribute("clist", page.getContent());
		model.addAttribute("message", message);
		return "allCitizens";

	}
	@GetMapping("/edit")
	public String editCitizen(Model model,
			@RequestParam Integer id
			
			) {
		Citizen citizen=serviceImp.getCitizenById(id);
		model.addAttribute("objCitizen",citizen);
		return "editCitizen";
	}
	
	@PostMapping("/update")
	public String updateCitizen(
			RedirectAttributes attribute,
			@ModelAttribute Citizen citizen
			
			) {
		String dose=citizen.getCitizenDoses();
		if(dose.equals("Second Dose")) {
			citizen.setMailFlag(1);
		}else {
			citizen.setMailFlag(0);
		}
		serviceImp.updateCitizen(citizen);
		attribute.addAttribute("message", "Citizen'"+citizen.getCitizenName()+"' Upadated Successfully!");
		log.info(citizen.getCitizenName()+" Citizen Upadated Successfully!");
		return "redirect:all";
	}
	
	@GetMapping("/delete")
	public String deleteCitizen(
			RedirectAttributes attribute,
			@RequestParam Integer id
			) {
		serviceImp.deleteCitizenById(id);
		attribute.addAttribute("message", id+" Citizen deleted successfully");
		log.info(id+" Citizen deleted successfully");
		return "redirect:all";
		
	}
	@GetMapping("/byaadhar")
	public String searchbyAaadhar(
		
			@RequestParam (required = false) String message,
			Model model
			) {
	
	   model.addAttribute("message", message);
		return "searchPage";
		
	}
	
	@GetMapping("/byaadharno")
	public String searchbyAaadharNo(
			@RequestParam Integer citizenAadharNo,
			@RequestParam (required = false) String message,
			Model model
			) {
		
		Citizen citizen=serviceImp.getCitizenByAadhar(citizenAadharNo);
	   model.addAttribute("message", message);
	   model.addAttribute("citizebObj", citizen);
		return "searchPage";
		
	}
	

}
