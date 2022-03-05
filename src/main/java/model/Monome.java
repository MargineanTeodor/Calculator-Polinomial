package model;

public class Monome {
    private int coeficient;
    private int vizita;
    private int putere;
    public int getVizita() {
        return vizita;
    }
    public void setVizita(int vizita) {
        this.vizita = vizita;
    }
    public Monome(int coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
        this.vizita=0;
    }
    public int getCoeficeient() {
        return coeficient;
    }
    public void setCoeficeient(int coeficeient) {
        this.coeficient = coeficeient;
    }
    public int getPutere() {
        return putere;
    }
    public void setPutere(int putere) {
        this.putere = putere;
    }
    @Override
    public String toString() {
        return ""+coeficient+"x^"+putere;
    }
}
