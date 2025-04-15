package fr.formation;

import java.util.List;

public class ProduitService {
    // Inversion of Control : ce n'est plus à ProduitService de gérer l'instance de sa dépendance
    private ProduitRepository repository;

    public ProduitService() { }

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public void setProduitRepository(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> findAll() {
        return this.repository.findAll();
    }
}
