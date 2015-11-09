package dac.univ_smb.dame_aux_cles.model;

/**
 * Created by jujulejaffa on 09/11/15.
 */
public class Personne {


    private int idPersonne;
    private String loginPersonne;
    private String mdpPersonne;
    private boolean isAdmin;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public String getLoginPersonne() {
        return loginPersonne;
    }

    public void setLoginPersonne(String loginPersonne) {
        this.loginPersonne = loginPersonne;
    }

    public String getMdpPersonne() {
        return mdpPersonne;
    }

    public void setMdpPersonne(String mdpPersonne) {
        this.mdpPersonne = mdpPersonne;
    }


}
