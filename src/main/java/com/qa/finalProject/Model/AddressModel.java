package com.qa.finalProject.Model;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
public class AddressModel implements Serializable{
	@Id
	@Column(name="postcode")private String postcode;
	@NotBlank
	@Column(name="address_line_1")private String addressLine1;
	@NotBlank
	@Column(name="address_line_2")private String addressLine2;
	@NotBlank
	@Column(name="city")private String city;
	@NotBlank
	@Column(name="county")private String county;
	@NotBlank
	@Column(name="country")private String country;
	
	public AddressModel() {}
	
	public AddressModel(String postcode,String addressLine1, String addressLine2, String city, String county, String country) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.county = county;
		this.country = country;
		this.postcode = postcode; 
	}

	public String getPostcode() {  
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
