package fr.formation;

import fr.formation.builder.DemoBuilder;
import fr.formation.singleton.DemoSingleton;

public class Application {
    public static void main(String[] args) {
        // singleton();
        builder();
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
}
