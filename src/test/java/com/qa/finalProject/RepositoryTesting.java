package com.qa.finalProject;

	import static org.junit.Assert.assertTrue;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringRunner;

import com.qa.finalProject.Model.AddressModel;
import com.qa.finalProject.Model.DecorModel;
import com.qa.finalProject.Repository.AddressRepository;


	@RunWith(SpringRunner.class)
	@ContextConfiguration(classes = {FinalProjectApplication.class})
	@DataJpaTest
	public class RepositoryTesting {

		@Autowired
			private TestEntityManager entityManager;
			
			@Autowired
			private AddressRepository MyRepo;
			
			@Test
			public void retrieveByPostcodeTest() {
				AddressModel model1 = new AddressModel("EC2M 2AF", "3 South Place", "fdssfsdfs", "London",	"East Central London", "United Kingdom");
				entityManager.persist(model1);
				entityManager.flush();
				assertTrue(MyRepo.findById(model1.getPostcode()).isPresent());
			}
			
				
	}

