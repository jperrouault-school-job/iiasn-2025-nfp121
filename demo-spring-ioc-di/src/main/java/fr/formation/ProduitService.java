package fr.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProduitService {
    // Inversion of Control : ce n'est plus à ProduitService de gérer l'instance de sa dépendance
    @Autowired
    private ProduitRepository repository;
    
    @Autowired
    private JsonHttpClient httpClient;

    public ProduitService() { }

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public void setProduitRepository(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> findAll() {
        this.httpClient.get("https://jsonplaceholder.typicode.com/photos/1", Object.class);
        
        return this.repository.findAll();
    }
}
