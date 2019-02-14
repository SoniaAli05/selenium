package com.qa.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalProject.Model.VenueModel;

@Repository
public interface VenueRepository extends JpaRepository<VenueModel,Long>{

}
