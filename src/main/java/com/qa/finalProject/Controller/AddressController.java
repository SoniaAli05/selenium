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
import com.qa.finalProject.Model.AddressModel;
import com.qa.finalProject.Repository.AddressRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired 
	AddressRepository addressRepo;

	// Method to create an address
	@PostMapping("/address")
	public AddressModel createAddress(@Valid @RequestBody AddressModel mSDM) {
		return addressRepo.save(mSDM);
	}
 
	// Method to get an address
	@GetMapping("/address/{id}")
	public AddressModel createAddressbyID(@PathVariable(value = "id") String postcode) {
		return addressRepo.findById(postcode).orElseThrow(() -> new VenueException("AddressModel", "id", postcode));
	}
	
	//Method to get all address
	@GetMapping("/address") 
	public List<AddressModel>getAllAddress(){
		return addressRepo.findAll();
	}
	// Method to update an address 
	@PutMapping("/address/{id}")
	public AddressModel update(@PathVariable(value = "id") String postcode,
			@Valid @RequestBody AddressModel AddressDetails) {

		AddressModel mSDM = addressRepo.findById(postcode).orElseThrow(() -> new VenueException("Address", "id", postcode));

		mSDM.setAddressLine1(AddressDetails.getAddressLine1());
		mSDM.setAddressLine2(AddressDetails.getAddressLine2());
		mSDM.setCity(AddressDetails.getCity()); 
		mSDM.setCounty(AddressDetails.getCounty());
		mSDM.setCountry(AddressDetails.getCountry());

		AddressModel updateData = addressRepo.save(mSDM);
		return updateData;
	}

	// method to remove an address
	@DeleteMapping("/address/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(value = "id") String postcode) {
		AddressModel mSDM = addressRepo.findById(postcode).orElseThrow(() -> new VenueException("Address", "id", postcode));

		addressRepo.delete(mSDM);
		return ResponseEntity.ok().build();
 
	}

}
