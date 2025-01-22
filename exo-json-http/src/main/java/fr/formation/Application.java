package fr.formation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.model.Photo;

public class Application {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();
        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpRequest request = HttpRequest
                .newBuilder(new URI("https://jsonplaceholder.typicode.com/photos"))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            byte[] json = response.body();

            // Photo[] photos = mapper.readValue(json, Photo[].class);
            // List<Photo> photos = Arrays.asList(mapper.readValue(json, Photo[].class));
            List<Photo> photos = mapper.readValue(json, new TypeReference<List<Photo>>() {});

            System.out.println(photos.size() + " photos");
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
    }
}