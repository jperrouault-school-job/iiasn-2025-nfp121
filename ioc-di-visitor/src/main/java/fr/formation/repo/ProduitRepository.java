package fr.formation.repo;

import java.util.List;

import fr.formation.annotation.Component;
import fr.formation.model.Produit;


@Component
public class ProduitRepository {
    public List<Produit> findAll() {
        return List.of(
            new Produit(),
            new Produit(),
            new Produit()
        );
    }
}
