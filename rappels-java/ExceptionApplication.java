import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ExceptionApplication {
    // Le mot-clé "throws", à ajouter dans la signature d'une méthode, pour indiquer que vous ne gérez pas l'erreur
    // public static void main(String[] args) throws IOException {
    public static void main(String[] args) {
        int[] tab = new int[2];

        try {
            int a = 5 / 0;
            tab[3] = 52;
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("OUPS");
        }
        
        catch (Exception e) {
            System.out.println("Oula la la là il y a une erreur inconnue");
        }
        
        System.out.println("FIN !!!!");
        
        // FileInputStream fis = null;
        // try {
        //     // Files.readAllBytes(null);
        //     fis = new FileInputStream("/workspace/demo-builder/pom.xml");
        //     tab[3] = 52;
        // }

        // catch (FileNotFoundException e) {
        //     System.out.println("Le fichier est introuvable !");
        // }

        // finally {
        //     if (fis != null) {
        //         try {
        //             System.out.println("Fermeture du fichier");
        //             fis.close();
        //         }

        //         catch (Exception e) {
        //             System.out.println("Impossible de fermer le fichier");
        //         }
        //     }
        // }

        // Syntaxe try-with-resources
        try (FileInputStream fis = new FileInputStream("/workspace/demo-builder/pom.xml")) {
            tab[3] = 52;
        }

        catch (FileNotFoundException e) {
            System.out.println("Le fichier est introuvable !");
        }

        catch (IOException e) {
            System.out.println("Exception IO");
        }
        
        catch (Exception e) {
            System.out.println("Erreur inconnue ... :(");
        }

        // Ajoute le finally avec la fermeture de la ressource !
    }
}
