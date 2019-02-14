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
import com.qa.finalProject.Model.DecorModel;
import com.qa.finalProject.Repository.DecorRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class DecorController {

	@Autowired
	DecorRepository decorRepo;

	// Method to create a decor
	@PostMapping("/decor")
	public DecorModel createDecor(@Valid @RequestBody DecorModel mSDM) {
		return decorRepo.save(mSDM);
	}

	// Method to get a decor
	@GetMapping("/decor/{id}")
	public DecorModel createDecorbyID(@PathVariable(value = "id") Long decorId) {
		return decorRepo.findById(decorId).orElseThrow(() -> new VenueException("DecorModel", "id", decorId));
	}

	// Method to get all decor
	@GetMapping("/decor")
	public List<DecorModel> getAllDecor() {
		return decorRepo.findAll();
	}
 
	// Method to update a decor
	@PutMapping("/decor/{id}")
	public DecorModel update(@PathVariable(value = "id") Long decorId, @Valid @RequestBody DecorModel DecorDetails) {

		DecorModel mSDM = decorRepo.findById(decorId).orElseThrow(() -> new VenueException("Decor", "id", decorId));

		mSDM.setDecorName(DecorDetails.getDecorName());
		mSDM.setCompanyInfo(DecorDetails.getCompanyInfo());
		mSDM.setDecorLocation(DecorDetails.getDecorLocation());

		DecorModel updateData = decorRepo.save(mSDM);
		return updateData;
	}

	// Method to remove a decor
	@DeleteMapping("/decor/{id}")
	public ResponseEntity<?> deleteDecor(@PathVariable(value = "id") Long decorId) {
		DecorModel mSDM = decorRepo.findById(decorId).orElseThrow(() -> new VenueException("Decor", "id", decorId));

		decorRepo.delete(mSDM);
		return ResponseEntity.ok().build();

	}
}
