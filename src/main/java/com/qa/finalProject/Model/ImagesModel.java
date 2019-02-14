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
@Table(name = "colourimages")
@EntityListeners(AuditingEntityListener.class)
public class ImagesModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="imageID")private Long imageId;
	@NotBlank
	@Column(name="imageRef")private String imageRef;
	@NotBlank
	@Column(name="colour")private String colour;
	
	public ImagesModel() {}

	public ImagesModel(String imageRef, String colour) {
		this.imageRef = imageRef;
		this.colour = colour;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) { 
		this.imageId = imageId;
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	public String getColour() {
		return colour; 
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
}
