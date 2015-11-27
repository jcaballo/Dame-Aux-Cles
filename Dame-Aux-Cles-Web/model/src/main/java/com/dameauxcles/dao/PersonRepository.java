package com.dameauxcles.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dameauxcles.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	Person findByLoginPersonne(String loginPersonne);
	
	ArrayList<Person> findByIsAdmin(boolean isAdmin);
	
	void delete(Person personne);
	
	Person save(Person personne);
}
