package fr.formation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Configurator.setRootLevel(Level.DEBUG);

        ApplicationContext ctx = new ApplicationContext();

        ProduitController ctrl = ctx.getBean(ProduitController.class);

        System.out.println(ctrl.findAll());
    }
}
