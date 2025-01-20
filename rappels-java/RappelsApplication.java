public class RappelsApplication {
    public static void main(String[] args) {
        int a = 42;             // 4 octets
        Object b = null;
        Integer c = null;

        long d = 100; // 2x plus long => 8 octets
        short e = 50; // 2x plus court => 2 octets
        byte f = 50; // encore 2x plus court => 1 octet

        char g = 'a';
        char h = 65;

        int i = g + 5;
        char j = (char)(g + 5);

        byte k = (byte)256;

        float l = 56; // 4 octets
        double m = 56; // la même chose que float, mais 2x plus grand => 8 octets

        boolean n = true; // 1 bit, mais encodé sur 1 octet

        // quelques variations
        a = 0x13; // Base 16
        System.out.println("Hexa " + a);

        a = 0b101; // Base 2
        System.out.println("Binaire " + a);

        a = 013; // Base 8
        System.out.println("Octale " + a);

        System.out.println("Hello world!");

    }

}
