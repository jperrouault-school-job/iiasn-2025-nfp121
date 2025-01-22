package fr.formation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

// Pattern Façade : on simple l'utilisation !
public class JsonHttpClient {
    private final HttpClient httpClient = new HttpClientProxy();
    private final ObjectMapper mapper = new ObjectMapper();

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
