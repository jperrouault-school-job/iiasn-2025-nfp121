import java.io.FileInputStream;

public class BitwiseFileInputApplication {
    public static void main(String[] args) {
        byte result = 0;

        try (FileInputStream fis = new FileInputStream("options.txt")) {
            result = (byte)fis.read();
        }

        catch (Exception e) {
            System.out.println("Erreur pendant la lecture du fichier ...");
            e.printStackTrace();
        }

        System.out.println( (1 & result >> 2) == 1 );
        System.out.println( (1 & result >> 1) == 1 );
        System.out.println( (1 & result) == 1 );
    }
}
