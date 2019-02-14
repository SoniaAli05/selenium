package com.qa.finalProject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.finalProject.Model.AddressModel;
import com.qa.finalProject.Model.CateringModel;
import com.qa.finalProject.Model.ContactModel;
import com.qa.finalProject.Model.CustomerModel;
import com.qa.finalProject.Model.DecorModel;
import com.qa.finalProject.Model.ImagesModel;
import com.qa.finalProject.Model.VenueModel;
import com.qa.finalProject.Repository.AddressRepository;
import com.qa.finalProject.Repository.CateringRepository;
import com.qa.finalProject.Repository.ContactRepository;
import com.qa.finalProject.Repository.CustomerRepository;
import com.qa.finalProject.Repository.DecorRepository;
import com.qa.finalProject.Repository.ImageRepo;
import com.qa.finalProject.Repository.VenueRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FinalProjectApplication.class})
@AutoConfigureMockMvc
public class IntegrationTesting {
	
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private AddressRepository myaddressrepo;
	
	@Autowired
	private VenueRepository myrepo;
	
	@Autowired
	private DecorRepository decorrepo;
	
	@Autowired
	private CateringRepository caterreopo;

	@Autowired
	private ContactRepository contactrepo;
	
	@Autowired
	private CustomerRepository customerrepo;
	
	@Autowired
	private ImageRepo imagerepo;

	@Autowired
	private VenueRepository venue1repo;

	@Autowired
	private AddressRepository add1repo;
	
	@Before
	public void clearDB() {
		myrepo.deleteAll();
		myaddressrepo.deleteAll();
		decorrepo.deleteAll();
		caterreopo.deleteAll();
		contactrepo.deleteAll();
		customerrepo.deleteAll();
		imagerepo.deleteAll();
		venue1repo.deleteAll();
		add1repo.deleteAll();
	} 
	 
	
	@Test
	public void findingAndRetrievingAddressFromDatabase() throws Exception {
		AddressModel model1 = new AddressModel("EC2M 2AF", "3 South Place", "fdssfsdfs", "London",	"East Central London", "United Kingdom");
		myaddressrepo.save(model1);  
		mvc.perform(get("/api/address")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content() 
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) 
			.andExpect(jsonPath("$[0].postcode", is("EC2M 2AF")));
	}
	
	
	@Test
	public void findingAndRetrievingVenueFromDatabase() throws Exception {
		VenueModel vmodel1 = new VenueModel("South Place Hotel","Civil Ceremony Licence; Exclusive Use; In the City; Small Hotel; Outdoor Licence", "d named as one of...","March: Fri 8th, Wed 13th, Thurs 28th; April: Mon 1st, Tues 9th, Tues 23rd","Wednesday 27th February, Wednesday 27th March, Wednesday 24th April",	"Less than 30 guests; 31 to 50 guests; 51 to 75 guests; 76 to 100 guests; 101 to 250 guests", "Prices may vary and are dependant upon choices, please contact the venue for futher information","Seated Meal Facilities; Buffet Meal Facilities; In House Catering; Allows Private Catering; Alcohol Licence","Confetti Permitted; Changing Room for Guests; Disabled Facilities; Pets Welcome");
		
		myrepo.save(vmodel1);  
		mvc.perform(get("/api/venue")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())  
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].venueName", is("South Place Hotel")));
	}
	
	@Test
	public void findingAndRetrievingDecorFromDatabase() throws Exception {
		DecorModel dmodel = new DecorModel("Eden Event","then do not hesitate to get in touch.", "London");
		decorrepo.save(dmodel);  
		mvc.perform(get("/api/decor") 
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())  
			.andExpect(content() 
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].decorName", is("Eden Event")));
	}
	
	@Test
	public void findingAndRetrievingCateringFromDatabase() throws Exception {
		CateringModel cmodel = new CateringModel("Buen Apetito"," tremendous talking point for anything from 30 guests, up to 400 guests.", "London",	"to confirm your booking, with the balance due 14 days before your wedding day.");
		caterreopo.save(cmodel);  
		mvc.perform(get("/api/catering") 
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())  
			.andExpect(content() 
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].cateringName", is("Buen Apetito")));
	}
	  
	@Test
	public void findingAndRetrievingContactFromDatabase() throws Exception {
		ContactModel comodel = new ContactModel("02051363146","southpalacehotel@gmail.com","southPalaceHotel",	"southPalaceHotel",	"southPalaceHotel");
		contactrepo.save(comodel);  
		mvc.perform(get("/api/contact") 
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())  
			.andExpect(content() 
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].mobileNo", is("02051363146")));
	}
	 


	@Test
	public void findingAndRetrievingCustomerFromDatabase() throws Exception {
		CustomerModel cumodel = new CustomerModel("Freya","freya");
		customerrepo.save(cumodel);  
		mvc.perform(get("/api/customer") 
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())   
			.andExpect(content() 
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].username", is("Freya")));
	} 
	
	@Test
	public void findingAndRetrievingImageFromDatabase() throws Exception {
		ImagesModel imodel = new ImagesModel("E:\\IndividualProject\\img\\All\\red.png","red");
		imagerepo.save(imodel);  
		mvc.perform(get("/api/image") 
			.contentType(MediaType.APPLICATION_JSON)) 
			.andExpect(status().isOk())  
			.andExpect(content() 
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].imageRef", is("E:\\IndividualProject\\img\\All\\red.png")));
	} 
	
	@Test
	public void deleteVenueFromDatabase() throws Exception {
		VenueModel vemodel = new VenueModel("South Place Hotel",	"Civil Ceremony Licence; Exclusive Use; In the City; Small Hotel; Outdoor Licence",	"sophisticated City of London meets the Cultural East End, and named as one of",	"March: Fri 8th, Wed 13th, Thurs 28th; April: Mon 1st, Tues 9th, Tues 23rd","Wednesday 27th February, Wednesday 27th March, Wednesday 24th April",	"Less than 30 guests; 31 to 50 guests; 51 to 75 guests; 76 to 100 guests; 101 to 250 guests",	"Prices may vary and are dependant upon choices, please contact the venue for futher information",	"Seated Meal Facilities; Buffet Meal Facilities; In House Catering; Allows Private Catering; Alcohol Licence",	"Confetti Permitted; Changing Room for Guests; Disabled Facilities; Pets Welcome");
		venue1repo.save(vemodel);  
		mvc.perform(get("/api/venue") 
			.contentType(MediaType.APPLICATION_JSON)) 
			.andExpect(status().isOk());  

	}  
	
	@Test
	public void deleteAddressFromDatabase() throws Exception {
		AddressModel admodel = new AddressModel("EC2M 2AF", "3 South Place", "fdssfsdfs", "London",	"East Central London", "United Kingdom");
		add1repo.save(admodel);  
		mvc.perform(get("/api/address") 
			.contentType(MediaType.APPLICATION_JSON)) 
			.andExpect(status().isOk());  

	}  
  
}   
  
