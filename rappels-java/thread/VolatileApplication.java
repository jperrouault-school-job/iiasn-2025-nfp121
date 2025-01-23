package thread;

public class VolatileApplication {
    // Avec "volatile", on empêche le CPU de mettre la valeur en cache
    private volatile static boolean finished = false;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            while (!finished) { // En fait, le CPU il utilise un cache
                // System.out.println("");
            }

            System.out.println(" Terminé !");
        };

        Thread t1 = new Thread(task);

        t1.start();

        Thread.sleep(20);

        finished = true;
        
        t1.join();
    }
}
