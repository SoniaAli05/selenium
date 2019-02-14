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
import com.qa.finalProject.Model.ContactModel;
import com.qa.finalProject.Repository.ContactRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class ContactController {

	@Autowired
	ContactRepository contactRepo;

	// Method to create a contact
	@PostMapping("/contact")
	public ContactModel createContact(@Valid @RequestBody ContactModel mSDM) {
		return contactRepo.save(mSDM);
	}

	// Method to get a contact
	@GetMapping("/contact/{id}")
	public ContactModel createContactbyID(@PathVariable(value = "id") Long contactId) {
		return contactRepo.findById(contactId).orElseThrow(() -> new VenueException("ContactModel", "id", contactId));
	}
	
	// Method to get all contacts
	@GetMapping("/contact")
	public List<ContactModel> getAllContact() {
		return contactRepo.findAll();
	}

	// Method to update a contact
	@PutMapping("/contact/{id}")
	public ContactModel update(@PathVariable(value = "id") Long ContactId,@Valid @RequestBody ContactModel ContactDetails) {

		ContactModel mSDM = contactRepo.findById(ContactId).orElseThrow(() -> new VenueException("Contact", "id", ContactId));

		mSDM.setMobileNo(ContactDetails.getMobileNo());
		mSDM.setEmail(ContactDetails.getEmail());
		mSDM.setTwitter(ContactDetails.getTwitter());
		mSDM.setFacebook(ContactDetails.getFacebook());
		mSDM.setInstagram(ContactDetails.getInstagram());

		ContactModel updateData = contactRepo.save(mSDM);
		return updateData;
	}

	// method to remove a contact
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable(value = "id") Long contactId) {
		ContactModel mSDM = contactRepo.findById(contactId).orElseThrow(() -> new VenueException("Film", "id", contactId));

		contactRepo.delete(mSDM);
		return ResponseEntity.ok().build();

	}
}
