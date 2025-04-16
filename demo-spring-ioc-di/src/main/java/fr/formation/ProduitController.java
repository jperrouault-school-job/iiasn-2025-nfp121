package fr.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProduitController {
    // Inversion of Control : ce n'est plus à ProduitController de gérer l'instance de sa dépendance
    @Autowired
    private ProduitService produitService;

    // Setter
    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

    public List<Produit> findAll() {
        return this.produitService.findAll();
    }
}
