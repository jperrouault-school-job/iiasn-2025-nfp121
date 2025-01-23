package thread;

public class PointApplication {
    public static void main(String[] args) throws InterruptedException {
        Point p = new Point();
        long start = System.nanoTime();

        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                synchronized (p) {
                    p.translate(1, 1);
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.nanoTime();

        System.out.println("Temps d'exécution = " + (float)((end - start) / 1_000_000) + "ms");

        System.out.println(p);
    }
}
