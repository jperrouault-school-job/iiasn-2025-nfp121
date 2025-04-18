package fr.formation.singleton;

// Il n'y a qu'une seule instance disponible dans toute l'application
public class DemoSingleton {
    private static DemoSingleton instance;

    private DemoSingleton() { }

    public static DemoSingleton getInstance() {
        if (instance == null) {
            instance = new DemoSingleton();
        }

        return instance; 
    }
}
