package com.dameauxcles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dameauxcles.model.Alert;

public interface AlerteRepository extends JpaRepository<Alert, Long>{

	
}
