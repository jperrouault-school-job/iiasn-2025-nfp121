package fr.formation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.formation.annotation.Bean;
import fr.formation.annotation.Component;
import fr.formation.annotation.Configuration;
import fr.formation.annotation.Inject;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApplicationContext {
    private Map<Class<?>, Object> instances = new HashMap<>();
    
    public ApplicationContext() {
        // Créer les instances ....
        List<Class<?>> classes = this.findAllClasses("fr.formation");

        log.debug("Création des instances : {}", classes);

        for (Class<?> clz : classes) {
            if (clz.isAnnotationPresent(Component.class)) {
                instances.put(clz, BeanFactory.createBean(clz));
            }

            else if (clz.isAnnotationPresent(Configuration.class)) {
                Object config = BeanFactory.createBean(clz);
                instances.put(clz, config);

                for (Method m : clz.getDeclaredMethods()) {
                    if (m.isAnnotationPresent(Bean.class)) {
                        m.setAccessible(true);

                        try {
                            instances.put(m.getReturnType(), m.invoke(config));
                            log.debug("Méthode {} exécutée et instance {} récupérée !", m.getName(), m.getReturnType().getSimpleName());
                        }

                        catch (Exception e) {
                            log.error("Impossible d'exécuter la méthode {} : {}", m.getName(), e.getMessage());
                        }
                    }
                }
            }
        }

        // Parcourir les classes à la recherche des Field qui sont annotés de @Inject
        // Si le Field est annoté, on injecte (via le setter ou via le Field directement)
        // La dépendance correspondante
        // On peut connaitre le type de dépendance grâce à field.getType()

        for (Object instance : instances.values()) {
            for (Field f : instance.getClass().getDeclaredFields()) {
                if (f.isAnnotationPresent(Inject.class)) {
                    log.debug("Injection d'une dépendance de type {} ...", f.getType().getSimpleName());

                    Object dependency = instances.get(f.getType());

                    if (dependency == null) {
                        log.error("L'instance est null !");
                        continue;
                    }

                    f.setAccessible(true);

                    try {
                        f.set(instance, dependency);
                    }

                    catch (Exception e) {
                        log.error("Impossible d'injecter la dépendance : {}", e.getMessage());
                        continue;
                    }
                }
            }
        }
    }

    public <T> T getBean(Class<T> clz) {
        return (T)this.instances.get(clz);
    }

    private List<Class<?>> findAllClasses(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        for (String line : reader.lines().toList()) {
            if (!line.endsWith(".class")) { // Répertoire ... donc sous-package !
                classes.addAll(this.findAllClasses(packageName + "." + line));
                continue;
            }

            String className = line.substring(0, line.length() - 6);

            try {
                Class<?> clz = Class.forName(packageName + "." + className);

                classes.add(clz);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return classes;
    }

}
