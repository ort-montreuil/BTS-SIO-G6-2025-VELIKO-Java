package sio.velikojava.model;

public class User {
    private int idUser;
    private String emailUser;
    private String mdpUser;

    public User(int idUser, String emailUser, String mdpUser) {
        this.idUser = idUser;
        this.emailUser = emailUser;
        this.mdpUser = mdpUser;
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

}
