package fr.formation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadApplication {
    public static void main(String[] args) {
        // Thread t1 = new Thread(() -> {
        //     for (int i = 0; i < 1_000_000; i++) {
        //         System.out.println(i);
        //     }
        // });

        // t1.start();

        // 100 Threads créés d'office
        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        threadPool.submit(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.println(i);
            }
        }); // Contrairement au new Thread(Runnable), ici ça démarre tout de suite

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("OK SCHEDULER !");
        }, 0, 1, TimeUnit.SECONDS);

        System.out.println("Fin !");
    }
}
