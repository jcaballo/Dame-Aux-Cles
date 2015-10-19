package com.dameauxcles.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dameauxcles.model.Person;

@RestController
public class PersonTestController {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/users")
    public Person users()//(@RequestParam(value="name", defaultValue="World") String name) 
    {
		return null;
    }
}
