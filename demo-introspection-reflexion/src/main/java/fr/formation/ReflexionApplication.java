package fr.formation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflexionApplication {
    public static void main(String[] args) throws Exception {
        // Constructor<Photo> ctor = Photo.class.getConstructor(String.class);
        Constructor<?> ctor = Class.forName("fr.formation.Photo").getConstructor(String.class);
        Photo photo = (Photo)ctor.newInstance("Babar");

        Method m = photo.getClass().getDeclaredMethod("privateDemo");

        m.setAccessible(true);

        m.invoke(photo);
    }
}
