package fr.formation.controller;

import java.util.List;

import fr.formation.annotation.Controller;
import fr.formation.annotation.GetMapping;
import fr.formation.annotation.Inject;
import fr.formation.chainofresp.annotation.Json;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

@Controller
public class ProduitController {
    // Inversion of Control : ce n'est plus à ProduitController de gérer l'instance de sa dépendance
    @Inject
    private ProduitService produitService;

    // Setter
    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/produit")
    @Json
    // @Xml
    // @Html
    public List<Produit> findAll() {
        return this.produitService.findAll();
    }
}
