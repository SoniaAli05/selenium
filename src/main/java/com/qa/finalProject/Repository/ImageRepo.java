package com.qa.finalProject.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalProject.Model.ImagesModel;


@Repository
public interface ImageRepo extends JpaRepository<ImagesModel,Long>{
	
	Collection<ImagesModel> findByColour(String colour);

}
