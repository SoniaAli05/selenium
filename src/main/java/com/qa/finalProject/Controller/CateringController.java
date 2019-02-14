package com.qa.finalProject.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.finalProject.Exception.VenueException;
import com.qa.finalProject.Model.CateringModel;
import com.qa.finalProject.Repository.CateringRepository;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class CateringController {

	@Autowired
	CateringRepository cateringRepo;
	
	//Method to create a person
	@PostMapping("/catering")
	public CateringModel createCaterer(@Valid @RequestBody CateringModel mSDM) {
		return cateringRepo.save(mSDM);
	}
	
	//Method to get a caterer
		@GetMapping("/catering/{id}")
		public CateringModel createCatererbyID(@PathVariable(value = "id")Long cateringId) {
			return cateringRepo.findById(cateringId).orElseThrow(()-> new VenueException("CateringModel", "id",cateringId));
		}
	
	//Method to get all caterers
		@GetMapping("/catering")
		public List<CateringModel>getAllCatering(){
			return cateringRepo.findAll();
		}

		//Method to update a caterer
		@PutMapping("/film/{id}")
		public CateringModel update (@PathVariable(value = "id")Long CateringId, @Valid @RequestBody CateringModel CateringDetails) {
			
			CateringModel mSDM = cateringRepo.findById(CateringId).orElseThrow(()-> new VenueException("Catering","id",CateringId));
			
			mSDM.setCateringName(CateringDetails.getCateringName());
			mSDM.setCateringInfo(CateringDetails.getCateringInfo());
			mSDM.setLocation(CateringDetails.getLocation());
			mSDM.setPrices(CateringDetails.getPrices());
			
			
			CateringModel updateData = cateringRepo .save(mSDM);
			return updateData;
		}		



}
