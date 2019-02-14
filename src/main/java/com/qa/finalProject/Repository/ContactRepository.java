package com.qa.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalProject.Model.ContactModel;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel,Long>{

}
