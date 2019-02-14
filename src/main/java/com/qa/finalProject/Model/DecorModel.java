package com.qa.finalProject.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "decor")
@EntityListeners(AuditingEntityListener.class)
public class DecorModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="decor_id")private Long decorId;
	@NotBlank
	@Column(name="decor_name")private String decorName;
	@NotBlank 
	@Column(name="company_info")private String companyInfo;
	@NotBlank
	@Column(name="decor_location")private String decorLocation;
	
	public DecorModel() {}
	
	public DecorModel(String decorName, String companyInfo, String decorLocation) {
		this.decorName = decorName;
		this.companyInfo = companyInfo;
		this.decorLocation = decorLocation; 
	} 
	public DecorModel(Long decorId, String decorName, String companyInfo, String decorLocation) {
		this.decorName = decorName;
		this.companyInfo = companyInfo;
		this.decorLocation = decorLocation; 
		this.decorId = decorId;
	} 

	public Long getDecorId() { 
		return decorId; 
	}

	public void setDecorId(Long decorId) {
		this.decorId = decorId;
	}

	public String getDecorName() {
		return decorName;
	}

	public void setDecorName(String decorName) {
		this.decorName = decorName;
	}

	public String getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	public String getDecorLocation() {
		return decorLocation;
	}

	public void setDecorLocation(String decorLocation) {
		this.decorLocation = decorLocation;
	}
	
}