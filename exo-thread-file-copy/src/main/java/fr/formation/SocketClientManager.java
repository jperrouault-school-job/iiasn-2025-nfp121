package fr.formation;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketClientManager {
    private List<SocketClient> clients = new ArrayList<>();

    public void add(Socket socket) {
        System.out.println("Creating new client ...");

        SocketClient client = new SocketClient(socket, this);

        synchronized (this.clients) {
            this.clients.add(client);
        }

        client.setReceiver(Application.THREAD_POOL.submit(client::copy));
        client.setEmitter(Application.THREAD_POOL.submit(client::send));
    }

    public void close(SocketClient client) {
        System.out.println("Closing client ...");

        // client.getEmitter().cancel(true);
        // client.getReceiver().cancel(true);

        synchronized (this.clients) {
            this.clients.remove(client);
        }
    }
}
