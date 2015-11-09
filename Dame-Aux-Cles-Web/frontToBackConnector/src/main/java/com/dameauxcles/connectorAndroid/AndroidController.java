package com.dameauxcles.connectorAndroid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dameauxcles.dao.PersonRepository;
import com.dameauxcles.model.Person;

@RestController
public class AndroidController {

	private PersonRepository personRepository;

	@Autowired(required = true)
    public AndroidController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/user")
    public Person user(@RequestParam(value="loginPersonne") String name) {
    	return this.personRepository.findByLoginPersonne(name);
    }
}
