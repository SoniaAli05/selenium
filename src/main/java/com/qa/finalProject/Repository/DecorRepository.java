package com.qa.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.finalProject.Model.DecorModel;

@Repository
public interface DecorRepository extends JpaRepository<DecorModel,Long>{

}
