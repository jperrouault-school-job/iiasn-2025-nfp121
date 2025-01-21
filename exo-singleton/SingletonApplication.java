public class SingletonApplication {
    public static void main(String[] args) {
        SingletonModel singleton1 = SingletonModel.getInstance();
        SingletonModel singleton2 = SingletonModel.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("C PAREIL");
        }

        else {
            System.out.println("C PAS PAREIL");
        }
    }
}
