package com.qa.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalProject.Model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Long>{

}
