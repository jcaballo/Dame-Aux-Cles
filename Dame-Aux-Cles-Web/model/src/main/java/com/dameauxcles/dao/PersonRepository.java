package com.dameauxcles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dameauxcles.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	
}
