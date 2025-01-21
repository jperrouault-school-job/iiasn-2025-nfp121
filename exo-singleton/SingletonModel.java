public class SingletonModel {
    private static SingletonModel instance;

    private SingletonModel() { }

    public static SingletonModel getInstance() {
        if (instance == null) {
            instance = new SingletonModel();
        }

        return instance;
    }

}
