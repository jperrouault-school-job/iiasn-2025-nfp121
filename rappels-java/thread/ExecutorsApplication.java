package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsApplication {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(200);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(200);

        // Envoyer la tâche dans le submit
        // executor.submit(() -> {
        //     while (true) {
        //         System.out.println("Afficher un message toutes les secondes");
        //         Thread.sleep(1000);
        //     }
        // });

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Afficher un message toutes les secondes");
        }, 0, 1, TimeUnit.SECONDS);
    }

}
