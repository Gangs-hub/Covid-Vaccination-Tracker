package in.covid.vaccination.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder.Default;
import lombok.Data;

@Data
@Entity
@Table(name="citizenTab")
public class Citizen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cId")
	private Integer citizenId;
	@Column(name="cName")
	private String citizenName;
	@Column(name="cGender")
	private String citizenGender;
	@Column(name="cAadharNo")
	private Integer citizenAadharNo;
	@Column(name="cEmail")
	private String citizenEmailId;
	@Column(name="cDoses")
	private String citizenDoses;
	@Column(name="cVaccinDate")
	private Date citizenVaccinedate;
	@Column(name="cVaccineName")
	private String citizenVacccineName;
	
	//@Column(columnDefinition = "integer default 1 ")
	@Column(name="emailFlag")
	private Integer mailFlag;
	
	
	
	
	
	
	
	

}
