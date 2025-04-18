package fr.formation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.formation.builder.DemoBuilder;
import fr.formation.generic.DemoGeneric;
import fr.formation.generic.DemoMethodGeneric;
import fr.formation.proxy.ProduitService;
import fr.formation.proxy.ProduitServiceProxy;
import fr.formation.singleton.DemoSingleton;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        // singleton();
        // builder();
        // proxy();
        // generic();
        multithreading();
    }

    public static void singleton() {
        // Une seule instance possible pour DemoSingleton
        // DemoSingleton s1 = new DemoSingleton();
        // DemoSingleton s2 = new DemoSingleton();
        DemoSingleton s1 = DemoSingleton.getInstance();
        DemoSingleton s2 = DemoSingleton.getInstance();

        System.out.println(s1 == s2);
    }

    public static void builder() {
        // new DemoBuilder(null, null, null, null, null);
        DemoBuilder.builder()
            .d1("null")
            .d3(null)
            .d5(null)
            .build()
        ;
    }

    public static void proxy() {
        ProduitService service = new ProduitService();
        service = new ProduitServiceProxy(service);

        service.findAll();
        service.findAll();
    }

    public static void generic() {
        // DemoGeneric demoG = new DemoGeneric();
        // String result = (String)demoG.demo("Une chaine ...");

        DemoGeneric<String, String, Object> demoG = new DemoGeneric<>();
        String result = demoG.demo("Une chaine ...", null, null);

        DemoGeneric<Integer, String, List<String>> demoG2 = new DemoGeneric<>();
        Integer r2 = demoG2.demo(42, null, null);

        List<String> strs = new ArrayList<>();
        Map< String, String> s;

        DemoMethodGeneric dmg = new DemoMethodGeneric();
        dmg.demo(String.class);
    }

    public static void multithreading() {
        System.out.println(Thread.currentThread().getName());

        // Thread Pool
        
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        threadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        threadPool.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
