public class BuilderApplication {
    public static void main(String[] args) {
        // DataSource ds = new DataSource("hostname", 3306, false, "username", "123456");
        
        DataSource ds = DataSource.builderV1()
            .hostname("hostname")
            .port(3306)
            .secure(false)
            .username("username")
            .password("123456")
            .build()
        ;
    }
}
