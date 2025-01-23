package socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerApplication {
    public static void main(String[] args) {
        int port = 12345;

        // Avec telnet : telnet 127.0.0.1 12345
        // Avec netcat : netcat 127.0.0.1 12345
        try (ServerSocket server = new ServerSocket(port)) {
            // Attendre la connexion d'UN client
            Socket client = server.accept();

            System.out.println("Connexion de quelqu'un !!");

            int input = client.getInputStream().read();

            if (input == -1) {
                System.out.println("La liaison est terminée, on a pas de retour");
            }

            byte value = (byte)input;

            System.out.println("Valeur reçue : " + value);

            for (int i = 97; i < 107; i++) {
                client.getOutputStream().write(i);
                Thread.sleep(1000);
            }
        }
        
        catch (IOException e) {
            System.out.println("Impossible d'ouvrir la socket sur le port " + port);
        }

        catch (InterruptedException e) {
            System.out.println("Problème de thread interrompu");
            Thread.currentThread().interrupt();
        }
    }
}
