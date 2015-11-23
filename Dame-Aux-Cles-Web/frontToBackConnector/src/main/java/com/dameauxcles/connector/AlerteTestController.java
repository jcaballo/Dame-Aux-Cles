package com.dameauxcles.connector;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dameauxcles.dao.AlerteRepository;
import com.dameauxcles.dao.PersonRepository;
import com.dameauxcles.model.Alert;
import com.dameauxcles.model.Person;;

@RestController
public class AlerteTestController {
	
	private final PersonRepository personneRepository;
	private final AlerteRepository alerteRepository;
	
	@Autowired(required = true)
    public AlerteTestController(AlerteRepository alerteRepository, PersonRepository personneRepository) {
        this.alerteRepository = alerteRepository;
        this.personneRepository = personneRepository;
    }

    @RequestMapping("/alerts")
    public List<Alert> alerts()
    {
		return this.alerteRepository.findAll();
    }
    
    @RequestMapping(value = "/alert", method = RequestMethod.POST)
    public Alert addAlert(String loginPersonne, String destinataire, Date delais, String message, String pj)
    {
    	Person personne = personneRepository.findByLoginPersonne(loginPersonne);
    	Alert alert = new Alert();
    	alert.setIDPERSONNE(personne);
    	alert.setDESTINATAIREALERTE(destinataire);
    	alert.setDELAISALERTES(delais);
    	alert.setMESSAGEALERTE(message);
    	alert.setPJALERTE(pj);
    	
		return alerteRepository.save(alert);
    }
    
    @RequestMapping("/alerts/user")
    public List<Alert> user(@RequestParam(value="loginPersonne") String loginPersonne) {
    	return this.alerteRepository.findByIdPersonne_loginPersonne(loginPersonne);
    }
}
