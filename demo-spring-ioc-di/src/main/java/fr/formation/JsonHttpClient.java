package fr.formation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

// Pattern Façade : on simple l'utilisation !
@Component
public class JsonHttpClient {
    @Autowired
    private HttpClient httpClient;
    
    @Autowired
    private ObjectMapper mapper;

    public <T> T get(String uri, Class<T> clz) {
        try {
            HttpRequest request = HttpRequest
                .newBuilder(new URI(uri))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            return mapper.readValue(response.body(), clz);
        }

        catch (URISyntaxException e) {
            System.out.println("URI malformée !");
        }

        catch (IOException e) {
            System.out.println("Impossible d'exécuter la requête !");
        }

        catch (InterruptedException e) {
            System.out.println("Requête interrompue !");
        }

        return null;
    }
}
