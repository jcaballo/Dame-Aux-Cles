package com.dameauxcles.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dameauxcles.model.Alert;

public interface AlerteRepository extends JpaRepository<Alert, Long>{
	ArrayList<Alert> findByIdPersonne_loginPersonne(String loginPersonne);
//	void saveByDestinataireAlerte (String destinataireAlerte);
	 
}
