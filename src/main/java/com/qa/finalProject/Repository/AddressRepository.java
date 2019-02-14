package com.qa.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalProject.Model.AddressModel;
@Repository
public interface AddressRepository extends JpaRepository<AddressModel,String>{

}
