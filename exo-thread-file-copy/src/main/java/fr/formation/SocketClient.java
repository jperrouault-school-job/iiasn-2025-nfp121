package fr.formation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.Future;

import lombok.Getter;
import lombok.Setter;

public class SocketClient {
    private final Socket socket;
    private final SocketClientManager clientManager;

    @Getter @Setter
    private Future<?> receiver;

    @Getter @Setter
    private Future<?> emitter;
    
    public SocketClient(Socket socket, SocketClientManager clientManager) {
        this.socket = socket;
        this.clientManager = clientManager;
    }

    public void copy() {
        byte[] buffer = new byte[128];
        int len = 0;

        try (
            FileOutputStream fos = new FileOutputStream("copy.txt");
            InputStream input = this.socket.getInputStream()
        ) {
            System.out.println("Listening stream to copy in file ...");

            while ((len = input.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // Il faudra adapter ce code pour que le serveur reste en écoute active, et copie les informations uniquement si l'en-tête correspond à un transfert !
            // Pattern Observateur pour prévenir le client que la copie est OK !
        }

        catch (IOException e) {
            System.out.println("Error during copy!");
        }
    }
    
    public void send() {
        for (int i = 0; i < 1000; i++) {
            try {
                if (this.socket.isClosed()) {
                    this.clientManager.close(this);
                    break;
                }

                this.socket.getOutputStream().write(1);

                Thread.sleep(500);
            }
            
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                System.out.println("Can't stream, maybe socket is closed?!");
            }
        }
    }
}
