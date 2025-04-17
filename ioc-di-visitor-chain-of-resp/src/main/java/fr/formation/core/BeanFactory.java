package fr.formation.core;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BeanFactory {
    private BeanFactory() { }

    public static <T> T createBean(Class<T> clz) {
        try {
            log.debug("Création d'une instance de type {} ...", clz.getSimpleName());

            return clz.getConstructor().newInstance();
        }

        catch (Exception e) {
            log.error("Impossible de créer ce bean : {}", e.getMessage());
            
            return null;
        }
    }
}
