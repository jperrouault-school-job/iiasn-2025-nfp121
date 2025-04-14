package fr.formation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class IntrospectionApplication {
    public static void main(String[] args) throws Exception {
        
        Class<Photo> clz = Photo.class;

        for (Field f : clz.getFields()) {
            System.out.println(f.getName());
        }

        System.out.println("------------");

        for (var f : clz.getDeclaredFields()) {
            System.out.println(f.getName());
        }

        System.out.println("------------");

        for (Method m : clz.getMethods()) {
            System.out.println(m.getName());
        }

        System.out.println("------------");

        for (Method m : clz.getDeclaredMethods()) {
            System.out.println(m.getName());
        }

        System.out.println("------------");

        for (Constructor<?> ctor : clz.getDeclaredConstructors()) {
            System.out.println(ctor.getName());
            System.out.println(ctor.getParameterCount());

            for (Parameter p : ctor.getParameters()) {
                System.out.println(p.getType());
            }

            System.out.println(ctor.newInstance("un titre"));
        }


        Field fTitle = clz.getDeclaredField("title");

        Photo photo = new Photo("Le title !");

        fTitle.setAccessible(true);

        System.out.println(fTitle.get(photo));
    }
}
