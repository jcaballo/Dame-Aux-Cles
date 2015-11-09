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
	private int idAlerte;
	
	@ManyToOne
	@JoinColumn(name="IDPERSONNE")
	private Person idPersonne;
	
	@Column(name = "DESTINATAIREALERTE")
	private String destinataireAlerte;
	
	@Column(name = "DELAISALERTES")
	private Date delaisAlerte;
	
	@Column(name = "MESSAGEALERTE")
	private String messageAlerte;
	
	@Column(name = "PJALERTE")
	private String pjAlerte;

	public Alert(){
		
	}
	
	public Alert(int iDALERTE, Person iDPERSONNE, String dESTINATAIREALERTE, Date dELAISALERTES, String mESSAGEALERTE,
			String pJALERTE) {
		super();
		idAlerte = iDALERTE;
		idPersonne = iDPERSONNE;
		destinataireAlerte = dESTINATAIREALERTE;
		delaisAlerte = dELAISALERTES;
		messageAlerte = mESSAGEALERTE;
		pjAlerte = pJALERTE;
	}

	public int getIDALERTE() {
		return idAlerte;
	}

	public void setIDALERTE(int iDALERTE) {
		idAlerte = iDALERTE;
	}

	public Person getIDPERSONNE() {
		return idPersonne;
	}

	public void setIDPERSONNE(Person iDPERSONNE) {
		idPersonne = iDPERSONNE;
	}

	public String getDESTINATAIREALERTE() {
		return destinataireAlerte;
	}

	public void setDESTINATAIREALERTE(String dESTINATAIREALERTE) {
		destinataireAlerte = dESTINATAIREALERTE;
	}

	public Date getDELAISALERTES() {
		return delaisAlerte;
	}

	public void setDELAISALERTES(Date dELAISALERTES) {
		delaisAlerte = dELAISALERTES;
	}

	public String getMESSAGEALERTE() {
		return messageAlerte;
	}

	public void setMESSAGEALERTE(String mESSAGEALERTE) {
		messageAlerte = mESSAGEALERTE;
	}

	public String getPJALERTE() {
		return pjAlerte;
	}

	public void setPJALERTE(String pJALERTE) {
		pjAlerte = pJALERTE;
	}
	
}
