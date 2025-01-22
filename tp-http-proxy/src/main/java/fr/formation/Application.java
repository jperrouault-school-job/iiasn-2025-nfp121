package fr.formation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.model.Album;
import fr.formation.model.Photo;

public class Application {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClientProxy();
        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpRequest photosRequest = HttpRequest
                .newBuilder(new URI("https://jsonplaceholder.typicode.com/photos"))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> photosResponse = httpClient.send(photosRequest, BodyHandlers.ofByteArray());

            List<Photo> photos = mapper.readValue(photosResponse.body(), new TypeReference<List<Photo>>() {});

            System.out.println(photos.size() + " photos");

            for (Photo photo : photos) {
                HttpRequest albumRequest = HttpRequest
                    .newBuilder(new URI("https://jsonplaceholder.typicode.com/albums/" + photo.getAlbumId()))
                    .GET()
                    .build()
                ;
                HttpResponse<byte[]> albumResponse = httpClient.send(albumRequest, BodyHandlers.ofByteArray());
    
                Album album = mapper.readValue(albumResponse.body(), Album.class);

                photo.setAlbumTitle(album.getTitle());
            }

            Random rand = new Random();
            
            rand.ints(50, 0, photos.size())
                .mapToObj(i -> photos.get(i))
                .forEach(System.out::println);
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