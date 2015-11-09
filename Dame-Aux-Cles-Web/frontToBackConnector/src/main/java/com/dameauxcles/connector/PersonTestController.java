package com.dameauxcles.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dameauxcles.dao.PersonRepository;
import com.dameauxcles.model.Person;

@RestController
public class PersonTestController {
	
	private final PersonRepository personRepository;
	
	@Autowired(required = true)
    public PersonTestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/users")
    public List<Person> users()//(@RequestParam(value="name", defaultValue="World") String name) 
    {
		return this.personRepository.findAll();
    }
}
