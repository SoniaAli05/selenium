package com.qa.finalProject.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "catering")
@EntityListeners(AuditingEntityListener.class)
public class CateringModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="catering_id")private Long cateringId;
	@NotBlank
	@Column(name="catering_name")private String cateringName;
	@NotBlank
	@Column(name="catering_info")private String cateringInfo;
	@NotBlank
	@Column(name="location")private String location;
	@NotBlank
	@Column(name="prices")private String prices;

	public CateringModel() {}
	
	public CateringModel(String cateringName, String cateringInfo, String location, String prices) {
		this.cateringName = cateringName;
		this.cateringInfo = cateringInfo;
		this.location = location; 
		this.prices = prices;	
	}

	public Long getCateringId() {
		return cateringId;
	}

	public void setCateringId(Long cateringId) {
		this.cateringId = cateringId;
	}

	public String getCateringName() {
		return cateringName;
	}

	public void setCateringName(String cateringName) {
		this.cateringName = cateringName;
	}

	public String getCateringInfo() {
		return cateringInfo;
	}

	public void setCateringInfo(String cateringInfo) {
		this.cateringInfo = cateringInfo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}
	
}
