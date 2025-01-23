package thread;

public class ThreadApplication {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread qui écrit un truc " + i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        System.out.println("Hello world!");
    }
}
