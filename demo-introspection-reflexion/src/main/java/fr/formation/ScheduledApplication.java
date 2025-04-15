package fr.formation;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledApplication {
    public static void main(String[] args) throws Exception {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        Photo photo = new Photo("");

        for (Method m : Photo.class.getDeclaredMethods()) {
            Scheduled scheduled = m.getAnnotation(Scheduled.class);

            if (scheduled != null) {
                System.out.println("La méthode " + m.getName() + " est annotée !");

                m.setAccessible(true);

                scheduler.scheduleAtFixedRate(() -> {
                    try {
                        m.invoke(photo);
                    }

                    catch (Exception e) {
                        System.out.println("Impossible d'exécuter la méthode : " + e.getMessage());
                    }
                }, 0, scheduled.fixedRate(), TimeUnit.SECONDS);
            }
        }
    }
}
