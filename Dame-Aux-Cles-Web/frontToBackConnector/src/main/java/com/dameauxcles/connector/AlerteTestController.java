package com.dameauxcles.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dameauxcles.dao.AlerteRepository;
import com.dameauxcles.model.Alert;
import com.dameauxcles.model.Person;;

@RestController
public class AlerteTestController {
	
	private final AlerteRepository alerteRepository;
	
	@Autowired(required = true)
    public AlerteTestController(AlerteRepository alerteRepository) {
        this.alerteRepository = alerteRepository;
    }

    @RequestMapping("/alerts")
    public List<Alert> alerts()//(@RequestParam(value="name", defaultValue="World") String name) 
    {
		return this.alerteRepository.findAll();
    }
    
    @RequestMapping("/alerts/user")
    public List<Alert> user(@RequestParam(value="loginPersonne") String loginPersonne) {
    	return this.alerteRepository.findByIdPersonne_loginPersonne(loginPersonne);
    }
}
