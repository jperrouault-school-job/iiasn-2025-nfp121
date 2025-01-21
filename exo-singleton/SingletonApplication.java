import java.lang.reflect.Constructor;

public class SingletonApplication {
    public static void main(String[] args) throws Exception {
        SingletonModel singleton1 = SingletonModel.getInstance();
        // SingletonModel singleton2 = SingletonModel.getInstance();

        Constructor<SingletonModel> ctor = SingletonModel.class.getDeclaredConstructor();

        ctor.setAccessible(true);

        SingletonModel singleton2 = ctor.newInstance();

        if (singleton1 == singleton2) {
            System.out.println("C PAREIL");
        }

        else {
            System.out.println("C PAS PAREIL");
        }
    }
}
