package sio.velikojava.model;

public class User {
    private int idUser;
    private String emailUser;
    private String mdpUser;
    private String nomUser;
    private String prenomUser;
    private String villeUser;
    private String statutUser;
    private String renouvellerMdpUser;
    private int nombre_trajets;

    public User(String emailUser, int nombre_trajets) {
        this.emailUser = emailUser;
        this.nombre_trajets = nombre_trajets;
    }

    public User(int idUser, String emailUser, String mdpUser, String nomUser, String prenomUser, String villeUser, String statutUser, String renouvellerMdpUser) {
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.mdpUser = mdpUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.villeUser = villeUser;
        this.statutUser = statutUser;
        this.renouvellerMdpUser = renouvellerMdpUser;
    }

    public int getNombre_trajets() {
        return nombre_trajets;
    }

    public void setNombre_trajets(int nombre_trajets) {
        this.nombre_trajets = nombre_trajets;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getMdpUser() {
        return mdpUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public void setMdpUser(String mdpUser) {
        this.mdpUser = mdpUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getVilleUser() {
        return villeUser;
    }

    public void setVilleUser(String villeUser) {
        this.villeUser = villeUser;
    }

    public String getStatutUser() {
        return statutUser;
    }

    public void setStatutUser(String statutUser) {
        this.statutUser = statutUser;
    }

    public String getRenouvellerMdpUser() {
        return renouvellerMdpUser;
    }

    public void setRenouvellerMdpUser(String nouveauMdpUser) {
        this.renouvellerMdpUser = nouveauMdpUser;
    }
}
