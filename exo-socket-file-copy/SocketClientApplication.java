import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientApplication {
    public static void main(String[] args) {
        try (
            Socket client = new Socket("127.0.0.1", 12345);
            FileInputStream fis = new FileInputStream("fichier.txt")
        ) {
            byte[] buffer = new byte[4];
            int len = 0;

            while ((len = fis.read(buffer)) != -1) {
                client.getOutputStream().write(buffer, 0, len);
            }

            System.out.println("Copie terminée ! Déconnexion ...");
        }
        
        catch (IOException e) {
            System.out.println("Un problème pendant la connexion ...");
        }
    }
}
