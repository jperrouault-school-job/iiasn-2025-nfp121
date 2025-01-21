import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpImageApplication {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();

        try (FileOutputStream fos = new FileOutputStream("chat.jpg")) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiObglEsrAdmfYlyvOyV7aIZs3vz_RjwOZk3ZOj4TQB-37uDwopI2MxJk9bkiqmS-B484&usqp=CAU"))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            byte[] bytes = response.body();

            System.out.println("Taille = " + bytes.length);

            fos.write(bytes);
        }

        catch (URISyntaxException e) {
            System.out.println("Erreur sur l'URI");
        }

        catch (IOException e) {
            System.out.println("Erreur IO");
        }

        catch (InterruptedException e) {
            System.out.println("Interruption!");
        }
    }
}
