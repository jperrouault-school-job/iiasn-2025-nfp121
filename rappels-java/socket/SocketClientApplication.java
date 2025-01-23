package socket;
import java.io.IOException;
import java.net.Socket;

public class SocketClientApplication {
    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 12345)) {
            client.getOutputStream().write(87);

            int input;

            while ((input = client.getInputStream().read()) != -1) {
                byte value = (byte)input;

                System.out.println("Valeur reçue : " + value);
            }

            System.out.println("Connexion perdue ... :(");
        }
        
        catch (IOException e) {
            System.out.println("Un problème pendant la connexion ...");
        }
    }
}
