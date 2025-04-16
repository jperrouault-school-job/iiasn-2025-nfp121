package fr.formation;

import java.util.List;

import org.springframework.stereotype.Component;


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
