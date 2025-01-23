import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerApplication {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket server = new ServerSocket(port)) {
            Socket client = server.accept();
            
            System.out.println("Connexion de l'utilisateur !");
            
            int len = 0;
            byte[] buffer = new byte[4];

            try (FileOutputStream fos = new FileOutputStream("copy.txt")) {
                // read byte[] retourne le nombre d'octets lus. Il retourne -1 lorsqu'il n'y a plus aucun octet à lire
                while ((len = client.getInputStream().read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }

                System.out.println("Déconnexion de l'utilisateur, copie terminée !");
            }

            catch (Exception e) {
                System.out.println("Impossible de copier le fichier ...");
            }
        }
        
        catch (IOException e) {
            System.out.println("Impossible d'ouvrir la socket sur le port " + port);
        }
    }
}
