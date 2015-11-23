package dac.univ_smb.dame_aux_cles.model;

import java.util.Date;

/**
 * Created by jujulejaffa on 09/11/15.
 */
public class Alerte {

    private int idAlerte;
    private Personne idPersonne;
    private String destinataireAlerte;
    private Date delaisAlerte;
    private String messageAlerte;
    private String pjAlerte;

    public int getIdAlerte() {
        return idAlerte;
    }

    public void setIdAlerte(int idAlerte) {
        this.idAlerte = idAlerte;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getDestinataireAlerte() {
        return destinataireAlerte;
    }

    public void setDestinataireAlerte(String destinataireAlerte) {
        this.destinataireAlerte = destinataireAlerte;
    }

    public Date getDelaisAlerte() {
        return delaisAlerte;
    }

    public void setDelaisAlerte(Date delaisAlerte) {
        this.delaisAlerte = delaisAlerte;
    }

    public String getMessageAlerte() {
        return messageAlerte;
    }

    public void setMessageAlerte(String messageAlerte) {
        this.messageAlerte = messageAlerte;
    }

    public String getPjAlerte() {
        return pjAlerte;
    }

    public void setPjAlerte(String pjAlerte) {
        this.pjAlerte = pjAlerte;
    }
}
