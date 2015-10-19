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
	private int IDPERSONNE;
	
	@Column(name = "LOGINPERSONNE")
	private String LOGINPERSONNE;
	
	@Column(name = "MDPPERSONNE")
	private String MDPPERSONNE;
	
	@Column(name = "ISADMIN")
	private boolean ISADMIN;

	public int getIDPERSONNE() {
		return IDPERSONNE;
	}

	public void setIDPERSONNE(int iDPERSONNE) {
		IDPERSONNE = iDPERSONNE;
	}

	public String getLOGINPERSONNE() {
		return LOGINPERSONNE;
	}

	public void setLOGINPERSONNE(String lOGINPERSONNE) {
		LOGINPERSONNE = lOGINPERSONNE;
	}

	public String getMDPPERSONNE() {
		return MDPPERSONNE;
	}

	public void setMDPPERSONNE(String mDPPERSONNE) {
		MDPPERSONNE = mDPPERSONNE;
	}

	public boolean isISADMIN() {
		return ISADMIN;
	}

	public void setISADMIN(boolean iSADMIN) {
		ISADMIN = iSADMIN;
	}
	
}
