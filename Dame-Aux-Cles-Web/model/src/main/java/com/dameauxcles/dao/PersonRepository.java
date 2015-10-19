package com.dameauxcles.dao;

import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.findShortestPaths;
import org.springframework.data.repository.CrudRepository;
import com.dameauxcles.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

	
}
