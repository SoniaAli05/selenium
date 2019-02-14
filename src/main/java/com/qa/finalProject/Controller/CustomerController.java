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
import com.qa.finalProject.Model.CustomerModel;
import com.qa.finalProject.Repository.CustomerRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;

	// Method to create a customer
	@PostMapping("/customer")
	public CustomerModel createCustomer(@Valid @RequestBody CustomerModel mSDM) {
		return customerRepo.save(mSDM);
	}

	// Method to get a customer
	@GetMapping("/customer/{id}")
	public CustomerModel createCustomerbyID(@PathVariable(value = "id") Long customerId) {
		return customerRepo.findById(customerId)
				.orElseThrow(() -> new VenueException("CustomerModel", "id", customerId));
	}
	// Method to get all customers

	@GetMapping("/customer")
	public List<CustomerModel> getAllCustomer() {
		return customerRepo.findAll();
	}

	// Method to update a customer
	@PutMapping("/customer/{id}")
	public CustomerModel update(@PathVariable(value = "id") Long CustomerId,
			@Valid @RequestBody CustomerModel CustomerDetails) {

		CustomerModel mSDM = customerRepo.findById(CustomerId).orElseThrow(() -> new VenueException("Customer", "id", CustomerId));

		mSDM.setUsername(CustomerDetails.getUsername());
		mSDM.setPassword(CustomerDetails.getPassword());
	

		CustomerModel updateData = customerRepo.save(mSDM);
		return updateData;
	}

	// method to remove a customer
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerId) {
		CustomerModel mSDM = customerRepo.findById(customerId).orElseThrow(() -> new VenueException("Customer", "id", customerId));

		customerRepo.delete(mSDM);
		return ResponseEntity.ok().build();

	}

}
