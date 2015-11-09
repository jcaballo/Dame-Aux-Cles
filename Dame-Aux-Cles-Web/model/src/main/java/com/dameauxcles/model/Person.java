package com.dameauxcles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONNES")
public class Person {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "IDPERSONNE")
	private int idPersonne;
	
	@Column(name = "LOGINPERSONNE")
	private String loginPersonne;
	
	@Column(name = "MDPPERSONNE")
	private String mdpPersonne;
	
	@Column(name = "ISADMIN")
	private boolean isAdmin;

	public Person(){
		
	}
	
	public Person(int idPersonne, String loginPersonne, String mdpPersonne, boolean isAdmin) {
		this.idPersonne = idPersonne;
		this.loginPersonne = loginPersonne;
		this.mdpPersonne = mdpPersonne;
		this.isAdmin = isAdmin;
	}

	public int getidPersonne() {
		return idPersonne;
	}

	public void setidPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getloginPersonne() {
		return loginPersonne;
	}

	public void setloginPersonne(String loginPersonne) {
		this.loginPersonne = loginPersonne;
	}

	public String getmdpPersonne() {
		return mdpPersonne;
	}

	public void setmdpPersonne(String mdpPersonne) {
		this.mdpPersonne = mdpPersonne;
	}

	public boolean isisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
