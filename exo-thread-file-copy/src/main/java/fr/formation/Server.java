package fr.formation;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final SocketClientManager clientManager = new SocketClientManager();

    public void listen(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Listening on port " + port);

            while (true) {
                System.out.println("Listening connection ...");

                Socket client = server.accept();

                System.out.println("New connection!");

                clientManager.add(client);
            }
        }

        catch (IOException e) {
            System.out.println("Can't listen on port " + port);
        }
    }
}
