package fr.formation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {
    public static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(200);

    public static void main(String[] args) {
        Server server = new Server();

        Future<?> serverListening = THREAD_POOL.submit(() -> server.listen(12345));

        // On peut manipuler serverListening si on veut tout fermer
        // serverListening.cancel(true);
    }
}