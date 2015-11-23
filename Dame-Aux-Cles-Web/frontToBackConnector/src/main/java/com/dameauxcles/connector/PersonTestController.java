package com.dameauxcles.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Person> users(@RequestParam(value = "isAdmin") boolean isAdmin) {
		return this.personRepository.findByIsAdmin(isAdmin);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody Person personne) {
		this.personRepository.delete(personne);
	}

	@RequestMapping(value = "/signInUser", method = RequestMethod.POST)
	public void signInUser(@RequestBody Person personne) {
		this.personRepository.save(personne);
	}
}
