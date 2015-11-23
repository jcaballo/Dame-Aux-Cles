package dac.univ_smb.dame_aux_cles.model;

import java.util.Date;

/**
 * Created by jujulejaffa on 09/11/15.
 */
public class Alerte {

    private int idalerte;
    private Personne idpersonne;
    private String destinatairealerte;
    private Date delaisalertes;
    private String messagealerte;
    private String pjalerte;

    public int getIdalerte() {
        return idalerte;
    }

    public void setIdalerte(int idalerte) {
        this.idalerte = idalerte;
    }

    public Personne getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(Personne idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getDestinatairealerte() {
        return destinatairealerte;
    }

    public void setDestinatairealerte(String destinatairealerte) {
        this.destinatairealerte = destinatairealerte;
    }

    public Date getDelaisalertes() {
        return delaisalertes;
    }

    public void setDelaisalertes(Date delaisalertes) {
        this.delaisalertes = delaisalertes;
    }

    public String getMessagealerte() {
        return messagealerte;
    }

    public void setMessagealerte(String messagealerte) {
        this.messagealerte = messagealerte;
    }

    public String getPjalerte() {
        return pjalerte;
    }

    public void setPjalerte(String pjalerte) {
        this.pjalerte = pjalerte;
    }
}
