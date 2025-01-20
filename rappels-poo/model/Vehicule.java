package model;

public abstract class Vehicule {
    public int couleur = 0;
    public String modele = "Défaut";
    
    // TOUTES les instances partagent la même valeur
    // public static int couleur = 0;

    // CONSTANTE
    // public final int couleur = 0;

    public Vehicule() {
        System.out.println("FABRICATION VEHICULE");
    }
    
    public abstract void demarrer();
}
