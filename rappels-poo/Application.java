import model.Camion;
import model.Vehicule;
import model.Voiture;

public class Application {
    public static void main(String[] args) {
        // Object v1 = new Voiture();
        // Object v2 = v1;
        // new Voiture();
        // new Voiture();

        // // v1.demarrer();
        // // ((Vehicule)v1).demarrer();


        // Vehicule[] tab = new Vehicule[2];

        // tab[0] = new Camion();
        // tab[1] = new Voiture();

        // reference(tab);
        
        // tab[0].demarrer();
        // tab[1].demarrer();

        int a = 5;
        reference(a);
        System.out.println(a); // 5

        System.out.println("---");

        Voiture voiture = new Voiture();
        voiture.couleur = 5;
        voiture = reference(voiture);
        // System.out.println(voiture.couleur);
        System.out.println(voiture.modele);
    }

    public static Voiture reference(Voiture v) {
        // v.couleur = 6;
        // v = new Voiture();

        v.modele = "Nouveau modèle";

        return v;
    }

    public static int reference(int a) {
        a = 6;
        return a;
    }
    
    public static void reference(Vehicule[] tab) {
        tab[0] = tab[1];
        tab = new Vehicule[2];
    }
}
