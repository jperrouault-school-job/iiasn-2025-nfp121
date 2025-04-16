package fr.formation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Configurator.setRootLevel(Level.DEBUG);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        ProduitController ctrl = ctx.getBean(ProduitController.class);

        System.out.println(ctrl.findAll());
    }
}
