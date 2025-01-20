package generic;

import model.Vehicule;

public class Garagiste<T extends Vehicule> {
    // public void reparer(Voiture voiture) {
    //     System.out.println("Réparation de voiture");
    // }

    // public void reparer(Camion camion) {
    //     System.out.println("Réparation de camion");
    // }

    public void reparer(T vehicule) {
        System.out.println("Réparation d'un véhicule");
    }
}
