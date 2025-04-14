package fr.formation;

import java.lang.reflect.Method;

public class AnnotationApplication {
    public static void main(String[] args) throws Exception {
        Photo photo = new Photo("null");

        for (Method m : photo.getClass().getDeclaredMethods()) {
            MonAnnotation ma = m.getDeclaredAnnotation(MonAnnotation.class);

            if (ma != null) {
                System.out.println("L'annotation est présente !");

                m.setAccessible(true);

                m.invoke(photo);
            }
        }
    }
}
