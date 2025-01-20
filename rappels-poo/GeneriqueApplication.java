import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import generic.Garagiste;
import model.Camion;
import model.Vehicule;
import model.Voiture;

public class GeneriqueApplication {
    public static void main(String[] args) {
        List<Vehicule> vehicules = new ArrayList<>();
        vehicules.add(new Voiture());
        vehicules.add(new Camion());
        vehicules.add(new Camion());

        for (int i = 0; i < vehicules.size(); i++) {
            vehicules.get(i).demarrer();
        }

        // int i = 0;
        // for (System.out.println("Coucou"); i < 5; System.out.println("Fin passage")) {
        //     i++;
        // }

        Garagiste<Camion> garagiste = new Garagiste<>();

        garagiste.reparer(new Camion());

        // raw(vehicules); // Compile mais ça devient incohérent !! Plus de vérification
        for (int i = 0; i < vehicules.size(); i++) {
            vehicules.get(i).demarrer();
        }

        for (Vehicule v : vehicules) {
            v.demarrer();
            // vehicules.remove(v); // Pas possible, modification concurentielle interdite
        }

        Iterator<Vehicule> it = vehicules.iterator();
        while (it.hasNext()) {
            Vehicule v = it.next();

            v.demarrer();
            it.remove();
        }
    }
    
    public static void raw(List lst) {
        lst.add("La chaine de caractères");
    }
}
