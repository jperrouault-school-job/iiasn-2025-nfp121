import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class FactoryApplication {
    /*
        Collection<String>
        Collection<Integer>
        Collection<Vehicule>
        …

        Les paramètres en question :
        - tableau ou chainé (par défaut, tableau)
        - synchronisé ou non (par défaut pas synchro)
        - doublons ou non (par défaut, doublons)
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Collection<String> lst = CollectionFactory.createCollection(true, true, true);
        Collection<Integer> lst2 = CollectionFactory.createCollection(false, true, false);
        Collection<Object> lst3 = CollectionFactory.createCollection(true, false, false);

        lst.add("1");
        lst.add("3");
        lst.add("2");
        lst.add("1");

        System.out.println(lst);

        P p = new P();

        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                p.increment();
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);

        // Thread t1 = new Thread(task);
        // Thread t2 = new Thread(task);
        long start = System.nanoTime();
        
        Future<?> t1 = pool.submit(task);
        Future<?> t2 = pool.submit(task);
        // t1.start();
        // t2.start();
        
        t1.get();
        t2.get();

        // t1.join();
        // t2.join();

        long end = System.nanoTime();

        System.out.println((end - start) / (float)1_000_000);
        System.out.println(p.x.get());

        pool.shutdownNow();
    }

    public static class P {
        // private int x;
        private AtomicInteger x = new AtomicInteger(0);

        // public synchronized void increment() {
        //     x++;
        // }
        public void increment() {
            x.incrementAndGet();
        }
    }
}