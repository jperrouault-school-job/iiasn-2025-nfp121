package fr.formation;

public class BuilderApplication {
    public static void main(String[] args) {
        DataSource ds = DataSource.builder()
            .hostname("hostname")
            .port(3306)
            .secure(false)
            .username("username")
            .password("123456")
            .build()
        ;
    }
}
