package com.qa.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalProject.Model.CateringModel;

@Repository
public interface CateringRepository extends JpaRepository<CateringModel,Long>{

}
