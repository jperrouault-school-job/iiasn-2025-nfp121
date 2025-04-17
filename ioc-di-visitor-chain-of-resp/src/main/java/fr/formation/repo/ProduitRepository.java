package fr.formation.repo;

import java.math.BigDecimal;
import java.util.List;

import fr.formation.annotation.Component;
import fr.formation.model.Produit;


@Component
public class ProduitRepository {
    public List<Produit> findAll() {
        return List.of(
            Produit.builder()
                .id(1)
                .nom("Parachute de France")
                .prix(new BigDecimal("9999.9"))
                .build()
            ,
            Produit.builder()
                .id(2)
                .nom("Casque de parachutiste")
                .prix(new BigDecimal("499.9"))
                .build()
            ,
            Produit.builder()
                .id(3)
                .nom("Combinaison de parachutiste")
                .prix(new BigDecimal("449.5"))
                .build()
        );
    }
}
