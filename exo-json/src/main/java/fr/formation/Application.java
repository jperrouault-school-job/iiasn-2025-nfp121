package fr.formation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.model.Album;

public class Application {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        albums.add(Album.builder().id(1).name("Marie à Carré").build());
        albums.add(Album.builder().id(2).name("Alizée").build());
        
        try (FileOutputStream fos = new FileOutputStream("albums.json")) {
            byte[] jsonBytes = mapper.writeValueAsBytes(albums);

            fos.write(jsonBytes);
        }

        catch (IOException e) {
            System.out.println("Impossible de convertir en JSON dans ce fichier !");
        }
    }
}