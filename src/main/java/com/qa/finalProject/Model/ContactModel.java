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
@Table(name = "contact")
@EntityListeners(AuditingEntityListener.class)
public class ContactModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id")private Long contactId;
	@NotBlank
	@Column(name="mobile_no")private String mobileNo;
	@NotBlank
	@Column(name="email")private String email;
	@NotBlank
	@Column(name="twitter")private String twitter;
	@NotBlank
	@Column(name="facebook")private String facebook;	
	@NotBlank
	@Column(name="instagram")private String instagram;
	
	public ContactModel() {}
			
	public ContactModel(String mobileNo, String email, String twitter, String facebook, String instagram) {
		this.mobileNo = mobileNo;
		this.email = email;
		this.twitter = twitter;
		this.facebook = facebook;
		this.instagram = instagram;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}



}
