public class BitwiseApplication {
    public static void main(String[] args) {
        boolean bool1 = true;
        boolean bool2 = false;
        boolean bool3 = true;
        byte result = 0;

        if (bool1) {
            result = 1 << 2;
        }

        if (bool2) {
            // result = (byte)(result | (1 << 1));
            result |= 1 << 1;
        }

        if (bool3) {
            // result |= 1 << 0;
            result |= 1;
        }

        result = (byte)((bool1 ? 1 : 0) << 2 | (bool2 ? 1 : 0) << 1 | (bool3 ? 1 : 0 ));

        System.out.println("Valeur numérique : " + result);
        System.out.println("Valeur binaire : " + Integer.toBinaryString(result));
    }
}
