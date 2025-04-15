package fr.formation;

import java.util.List;

public class ProduitRepository {
    public List<Produit> findAll() {
        return List.of(
            new Produit(),
            new Produit(),
            new Produit()
        );
    }
}
