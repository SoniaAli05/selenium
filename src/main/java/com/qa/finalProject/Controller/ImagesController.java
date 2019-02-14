package com.qa.finalProject.Controller;

import java.util.Collection;
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
import com.qa.finalProject.Model.ImagesModel;
import com.qa.finalProject.Repository.ImageRepo;


@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class ImagesController {
	@Autowired
	ImageRepo imageRepo;
	
	// Method to create a image
		@PostMapping("/image")
		public ImagesModel createImage(@Valid @RequestBody ImagesModel mSDM) {
			return imageRepo.save(mSDM);
		}
		
		@PostMapping("/images")
		public Collection<ImagesModel> createImage(@Valid @RequestBody Collection<ImagesModel> mSDM) {
			for(ImagesModel image:mSDM) {
				imageRepo.save(image);
				
			}
			return mSDM;
		}
		

		// Method to get a image
		@GetMapping("/image/{id}")
		public ImagesModel createImagebyID(@PathVariable(value = "id") Long imageId) {
			return imageRepo.findById(imageId).orElseThrow(() -> new VenueException("ImagesModel", "id", imageId));
		}
		
		@GetMapping("/image/colour/{colour}")
		public Collection<ImagesModel> findImageByColour(@PathVariable(value = "colour") String colour) {
			return imageRepo.findByColour(colour);
		}

		// Method to get all images
		@GetMapping("/image")
		public List<ImagesModel> getAllImage() {
			return imageRepo.findAll();
		}

		// Method to update a image
		@PutMapping("/image/{id}")
		public ImagesModel update(@PathVariable(value = "id") Long ImageId, @Valid @RequestBody ImagesModel ImageDetails) {

			ImagesModel mSDM = imageRepo.findById(ImageId).orElseThrow(() -> new VenueException("Venue", "id", ImageId));

			mSDM.setImageRef(ImageDetails.getImageRef());
			mSDM.setColour(ImageDetails.getColour());


			ImagesModel updateData = imageRepo.save(mSDM);
			return updateData;
		}

		// method to remove a image
		@DeleteMapping("/image/{id}")
		public ResponseEntity<?> deleteVenue(@PathVariable(value = "id") Long imageId) {
			ImagesModel mSDM = imageRepo.findById(imageId).orElseThrow(() -> new VenueException("Image", "id", imageId));

			imageRepo.delete(mSDM);
			return ResponseEntity.ok().build();

		}

	
	
}
