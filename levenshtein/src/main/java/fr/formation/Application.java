package fr.formation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class Application {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Map<String, Class<?>> classes = findAllClasses("fr.formation");

            while (true) {
                System.out.println("------------------------------------------------");
                System.out.println("Saisir une classe :");
                String ask = sc.nextLine().trim();
                
                double similarity = 0;
                double maxSimilarity = 0;
                String selectedClassName = "";

                for (String className : classes.keySet()) {
                    int distance = LevenshteinDistance.getDefaultInstance().apply(className, ask);
                    int maxLength = Math.max(className.length(), ask.length());

                    // Éviter la division par zéro
                    if (maxLength == 0) {
                        similarity = 100d;
                    }

                    similarity = (1.0 - ((double)distance / maxLength)) * 100;

                    if (maxSimilarity < similarity) {
                        maxSimilarity = similarity;
                        selectedClassName = className;
                    }
                }

                if (maxSimilarity >= 50) {
                    System.out.println(selectedClassName + " retenue avec une probabilité de " + maxSimilarity + "% !");
    
                    try {
                        Object instance = classes.get(selectedClassName).getConstructor().newInstance();
    
                        System.out.println(instance);
                    }
    
                    catch (Exception e) {
                        System.out.println("Impossible d'installer " + selectedClassName + " !");
                        e.printStackTrace();
                    }
                }

                else {
                    System.out.println("Pas de classe trouvée !");
                }
            }
        }
    }

    private static Map<String, Class<?>> findAllClasses(String packageName) {
        Map<String, Class<?>> classes = new HashMap<>();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        for (String line : reader.lines().toList()) {
            if (!line.endsWith(".class")) { // Répertoire ... donc sous-package !
                classes.putAll(findAllClasses(packageName + "." + line));
                continue;
            }

            String className = line.substring(0, line.length() - 6);

            try {
                Class<?> clz = Class.forName(packageName + "." + className);

                classes.put(clz.getSimpleName(), clz);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return classes;
    }
}