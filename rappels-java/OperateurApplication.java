public class OperateurApplication {
    public static void main(String[] args) {
        // andOr();
        // andOrXorNot();
        decalage();
    }

    public static void decalage() {
        byte a = 5;
        //      101

        // << on décale vers la gauche, on introduit à droite des 0
        // On introduit 2 0 à droite
        System.out.println(a << 2);

        // >> on décale vers la droite, on introduit à gauche des 0 OU des 1 (en fonction du bit de signe)
        System.out.println(a >> 2);

        // >>> on décale vers la droite, on introduit à gauche des 0
        System.out.println(a >>> 2);
    }

    public static void andOrXorNot() {
        //      101     5
        //      011     3

        int a = 5;
        int b = 3;

        // &    il faut avoir des 1 partout pour avoir 1, sinon ce sera 0
        // AND  001
        System.out.println(a & b);

        // |    1 et 0 font 1, 0 et 0 font 0, 1 et 1 font 1
        // OR   111
        System.out.println(a | b);

        // ^    1 et 0 font 1, 0 et 0 font 0, 1 et 1 font 0
        // XOR  110
        System.out.println(a ^ b);

        // ~    1 fait 0, 0 fait 1
        // NOT  010
        System.out.println(~a);
    }

    public static void andOr() {
        // System.out.println("Résultat = " + (alwaysTrue() || alwaysFalse()));
        // System.out.println("Résultat = " + (alwaysTrue() | alwaysFalse()));

        System.out.println("Résultat = " + (alwaysFalse() && alwaysTrue()));
        System.out.println("Résultat = " + (alwaysFalse() & alwaysTrue()));
    }

    public static boolean alwaysTrue() {
        System.out.println("true");
        return true;
    }

    public static boolean alwaysFalse() {
        System.out.println("false");
        return false;
    }
}
