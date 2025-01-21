import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientApplication {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.google.fr"))
                .GET()
                .build()
            ;

            HttpResponse<byte[]> response = httpClient.send(request, BodyHandlers.ofByteArray());

            byte[] bytes = response.body();

            System.out.println("Taille = " + bytes.length);
            System.out.println(new String(bytes));
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
