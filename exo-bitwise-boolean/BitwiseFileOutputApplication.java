import java.io.FileOutputStream;

public class BitwiseFileOutputApplication {
    public static void main(String[] args) {
        boolean bool1 = true;
        boolean bool2 = false;
        boolean bool3 = true;
        byte result = 0;

        result = (byte)((bool1 ? 1 : 0) << 2 | (bool2 ? 1 : 0) << 1 | (bool3 ? 1 : 0 ));

        try (FileOutputStream fos = new FileOutputStream("options.txt")) {
            fos.write(result);
        }

        catch (Exception e) {
            System.out.println("Erreur pendant l'écriture du fichier ...");
            e.printStackTrace();
        }
    }
}
