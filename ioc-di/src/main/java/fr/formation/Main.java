package fr.formation;

public class Main {
    public static void main(String[] args) {
        ProduitController ctrl = Factory.createProduitController();

        System.out.println(ctrl.findAll());
    }
}
