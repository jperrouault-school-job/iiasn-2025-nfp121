package fr.formation;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // On exécute le test avec Mockito
class ProduitControllerTest {
    // Simuler le service dont a besoin le controller
    @Mock
    private ProduitService service;

    // Demander à Mockito d'injecter les dépendances
    @InjectMocks
    private ProduitController ctrl;
    
    @Test
    void shouldFindAllCallService() {
        // given
        List<Produit> produits = List.of(new Produit());

        Mockito.when(this.service.findAll()).thenReturn(produits);

        // when
        List<Produit> result = ctrl.findAll();

        // then
        Mockito.verify(this.service).findAll();
        Assertions.assertEquals(produits, result);
    }
}
