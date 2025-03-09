package sio.velikojava.model;

public class Station {

    private String nomStation;
    private int nbDepart;

    public Station(String nomStation, int nbDepart) {
        this.nomStation = nomStation;
        this.nbDepart = nbDepart;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStation) {
        this.nomStation = nomStation;
    }

    public int getNbDepart() {
        return nbDepart;
    }

    public void setNbDepart(int nbDepart) {
        this.nbDepart = nbDepart;
    }
}
