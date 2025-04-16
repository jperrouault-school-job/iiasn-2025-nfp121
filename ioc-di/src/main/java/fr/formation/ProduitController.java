package fr.formation;

import java.util.List;

@Component
public class ProduitController {
    // Inversion of Control : ce n'est plus à ProduitController de gérer l'instance de sa dépendance
    @Inject
    private ProduitService produitService;

    // Setter
    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

    public List<Produit> findAll() {
        return this.produitService.findAll();
    }
}
