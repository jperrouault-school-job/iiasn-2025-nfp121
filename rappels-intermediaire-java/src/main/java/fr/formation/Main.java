package fr.formation;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Produit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Produit p1 = new Produit();
        Produit p2 = Produit.builder().id(3).nom("Toto").build();
        Produit p3 = new Produit(4, "Babar");

        List<Produit> produits = new ArrayList<>();

        produits.add(p1);
        produits.add(p2);
        produits.add(p3);

        // Parcourir de façon classique avec une boucle for
        for (int i = 0; i < produits.size(); i++) {
            System.out.println(produits.get(i));
        }
        System.out.println("----------");
        
        // Parcourir de façon classique avec un foreach
        for (Produit produit : produits) {
            System.out.println(produit);
        }
        System.out.println("----------");
        
        // Parcourir de façon fonctionnelle avec une lambda
        produits.forEach((p) -> {
            System.out.println(p);
        });
        System.out.println("----------");

        produits.forEach(p -> System.out.println(p));
        System.out.println("----------");

        // Parcourir de façon fonctionnelle avec une référence
        // > à une méthode qui attend un Produit et qui ne retourne rien
        produits.forEach(System.out::println);
    }
}
