package fr.formation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProduitServiceTest {
    @Mock
    private ProduitRepository repository;
    
    @Mock
    private JsonHttpClient httpClient;

    @InjectMocks
    private ProduitService service;

    @Test
    void shouldFindAllCallServices() {
        // given

        // when
        this.service.findAll();

        // then
        Mockito.verify(this.repository).findAll();
        
        Mockito.verify(this.httpClient).get("https://jsonplaceholder.typicode.com/photos/1", Object.class);

        Mockito.verify(this.httpClient).get(Mockito.any(), Mockito.any());
    }
}
