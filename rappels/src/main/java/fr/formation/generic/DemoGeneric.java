package fr.formation.generic;

public class DemoGeneric<T, I, C> {
    private T instance;

    public T demo(T a, I i, C c) {
        System.out.println("On fait un truc ici");

        this.instance = a;

        return a;
    }

    public void demo(Class<?> clz) {

    }
}
