package com.qa.finalProject.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.finalProject.Exception.VenueException;
import com.qa.finalProject.Model.VenueModel;
import com.qa.finalProject.Repository.VenueRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class VenueController {
	@Autowired
	VenueRepository venueRepo;

	// Method to create a venue
	@PostMapping("/venue")
	public VenueModel createVenue(@Valid @RequestBody VenueModel mSDM) {
		return venueRepo.save(mSDM);
	}
 
	// Method to get a venue
	@GetMapping("/venue/{id}")
	public VenueModel createVenuebyID(@PathVariable(value = "id") Long venueId) {
		return venueRepo.findById(venueId).orElseThrow(() -> new VenueException("VenueModel", "id", venueId));
	}

	// Method to get all venues 
	@GetMapping("/venue")
	public List<VenueModel> getAllVenue() {
		return venueRepo.findAll();
	}

	// Method to update a venue
	@PutMapping("/venue/{id}")
	public VenueModel update(@PathVariable(value = "id") Long VenueId, @Valid @RequestBody VenueModel VenueDetails) {

		VenueModel mSDM = venueRepo.findById(VenueId).orElseThrow(() -> new VenueException("Venue", "id", VenueId));

		mSDM.setVenueName(VenueDetails.getVenueName());
		mSDM.setVenueType(VenueDetails.getVenueType());
		mSDM.setVenueInfo(VenueDetails.getVenueInfo());
		mSDM.setLateAvailability(VenueDetails.getLateAvailability());
		mSDM.setOpenEvents(VenueDetails.getOpenEvents());
		mSDM.setCapacity(VenueDetails.getCapacity());
		mSDM.setPrices(VenueDetails.getPrices());
		mSDM.setDiningOptions(VenueDetails.getDiningOptions());
		mSDM.setOtherFeatures(VenueDetails.getOtherFeatures());

		VenueModel updateData = venueRepo.save(mSDM);
		return updateData;
	}

	// method to remove a venue
	@DeleteMapping("/venue/{id}")
	public ResponseEntity<?> deleteVenue(@PathVariable(value = "id") Long venueId) {
		VenueModel mSDM = venueRepo.findById(venueId).orElseThrow(() -> new VenueException("Venue", "id", venueId));

		venueRepo.delete(mSDM);
		return ResponseEntity.ok().build();

	}

}
