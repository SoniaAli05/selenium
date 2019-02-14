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
@Table(name = "venue")
@EntityListeners(AuditingEntityListener.class)
public class VenueModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="venue_id")private Long venueId;
	@NotBlank
	@Column(name="venue_name")private String venueName;
	@NotBlank
	@Column(name="venue_type")private String venueType;
	@NotBlank
	@Column(name="venue_info")private String venueInfo;
	@NotBlank
	@Column(name="late_availability")private String lateAvailability;
	@NotBlank
	@Column(name="open_events")private String openEvents;
	@NotBlank
	@Column(name="capacity")private String capacity;
	@NotBlank
	@Column(name="prices")private String prices;
	@NotBlank
	@Column(name="dining_options")private String diningOptions;
	@NotBlank
	@Column(name="other_features")private String otherFeatures;
	
	public VenueModel() {}
	
	public VenueModel(String venueName, String venueType, String venueInfo, String lateAvailability, String openEvents, String capacity, String prices, String diningOptions, String otherFeatures) {
		this.venueName = venueName;
		this.venueType = venueType;
		this.venueInfo = venueInfo;
		this.lateAvailability = lateAvailability;
		this.openEvents = openEvents;
		this.capacity = capacity;
		this.prices = prices;  
		this.diningOptions = diningOptions;
		this.otherFeatures = otherFeatures; 
	}
	
 
	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueType() {
		return venueType;
	}

	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}

	public String getVenueInfo() {
		return venueInfo;
	}

	public void setVenueInfo(String venueInfo) {
		this.venueInfo = venueInfo;
	}

	public String getLateAvailability() {
		return lateAvailability;
	}

	public void setLateAvailability(String lateAvailability) {
		this.lateAvailability = lateAvailability;
	}

	public String getOpenEvents() {
		return openEvents;
	}

	public void setOpenEvents(String openEvents) {
		this.openEvents = openEvents;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getDiningOptions() {
		return diningOptions;
	}

	public void setDiningOptions(String diningOptions) {
		this.diningOptions = diningOptions;
	}

	public String getOtherFeatures() {
		return otherFeatures;
	}

	public void setOtherFeatures(String otherFeatures) {
		this.otherFeatures = otherFeatures;
	}
	

}
