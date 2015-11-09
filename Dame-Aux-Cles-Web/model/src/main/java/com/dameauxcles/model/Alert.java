package com.dameauxcles.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALERTES")
public class Alert {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "IDALERTE")
	private int IDALERTE;
	
	@ManyToOne
	@JoinColumn(name="IDPERSONNE")
	private Person IDPERSONNE;
	
	@Column(name = "DESTINATAIREALERTE")
	private String DESTINATAIREALERTE;
	
	@Column(name = "DELAISALERTES")
	private Date DELAISALERTES;
	
	@Column(name = "MESSAGEALERTE")
	private String MESSAGEALERTE;
	
	@Column(name = "PJALERTE")
	private String PJALERTE;

	public Alert(){
		
	}
	
	public Alert(int iDALERTE, Person iDPERSONNE, String dESTINATAIREALERTE, Date dELAISALERTES, String mESSAGEALERTE,
			String pJALERTE) {
		super();
		IDALERTE = iDALERTE;
		IDPERSONNE = iDPERSONNE;
		DESTINATAIREALERTE = dESTINATAIREALERTE;
		DELAISALERTES = dELAISALERTES;
		MESSAGEALERTE = mESSAGEALERTE;
		PJALERTE = pJALERTE;
	}

	public int getIDALERTE() {
		return IDALERTE;
	}

	public void setIDALERTE(int iDALERTE) {
		IDALERTE = iDALERTE;
	}

	public Person getIDPERSONNE() {
		return IDPERSONNE;
	}

	public void setIDPERSONNE(Person iDPERSONNE) {
		IDPERSONNE = iDPERSONNE;
	}

	public String getDESTINATAIREALERTE() {
		return DESTINATAIREALERTE;
	}

	public void setDESTINATAIREALERTE(String dESTINATAIREALERTE) {
		DESTINATAIREALERTE = dESTINATAIREALERTE;
	}

	public Date getDELAISALERTES() {
		return DELAISALERTES;
	}

	public void setDELAISALERTES(Date dELAISALERTES) {
		DELAISALERTES = dELAISALERTES;
	}

	public String getMESSAGEALERTE() {
		return MESSAGEALERTE;
	}

	public void setMESSAGEALERTE(String mESSAGEALERTE) {
		MESSAGEALERTE = mESSAGEALERTE;
	}

	public String getPJALERTE() {
		return PJALERTE;
	}

	public void setPJALERTE(String pJALERTE) {
		PJALERTE = pJALERTE;
	}
	
}
