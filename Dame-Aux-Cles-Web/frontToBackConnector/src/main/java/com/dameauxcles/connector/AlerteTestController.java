package com.dameauxcles.connector;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dameauxcles.dao.AlerteRepository;
import com.dameauxcles.dao.PersonRepository;
import com.dameauxcles.model.Alert;
import com.dameauxcles.model.Person;

import ch.qos.logback.core.net.SyslogOutputStream;;

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
    public Alert addAlert(@RequestBody Alert alerte)
    {
    	
		return alerteRepository.save(alerte);
    }
    
    @RequestMapping("/alerts/user")
    public List<Alert> user(@RequestParam(value="loginPersonne") String loginPersonne) {
    	return this.alerteRepository.findByIdPersonne_loginPersonne(loginPersonne);
    }
    
    @RequestMapping("/updateAlerte")
    public Alert updateAlerte(@RequestParam(value="idAlerte") int id) {
        System.out.println("Coucou");
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        Alert alerte = alerteRepository.findByIdAlerte(id);
        calendar.setTime(alerte.getDELAISALERTES());
        calendar.add (Calendar.DATE, +1);
        alerte.setDELAISALERTES(new Date(calendar.getTimeInMillis()));
        alerteRepository.save(alerte);
        return alerte;
    }
}
