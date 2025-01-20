package model;

public class Voiture extends Vehicule  {
    public Voiture() {
        System.out.println("FABRICATION VOITURE");
    }

    @Override
    public void demarrer() {
        System.out.println("La voiture démarre ...");
    }
}
