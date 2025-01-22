package fr.formation;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.formation.model.Album;
import fr.formation.model.Photo;

public class JsonApplication {
    public static void main(String[] args) {
        JsonHttpClient httpClient = new JsonHttpClient();

        List<Photo> photos = Arrays.asList(httpClient.get("https://jsonplaceholder.typicode.com/photos", Photo[].class));

        System.out.println(photos.size() + " photos");

        for (Photo photo : photos) {
            Album album = httpClient.get("https://jsonplaceholder.typicode.com/albums/" + photo.getAlbumId(), Album.class);

            photo.setAlbumTitle(album.getTitle());
        }

        Random rand = new Random();
        
        rand.ints(50, 0, photos.size())
            .mapToObj(i -> photos.get(i))
            .forEach(System.out::println);
    }
}