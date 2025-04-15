package fr.formation;

public class Photo {
    private int id;
    private String title;

    public Photo(String title) {
        this.title = title;
    }

    @Scheduled(fixedRate = 5)
    public void demo() {
        System.out.println("Rien");
    }

    @MonAnnotation
    @Scheduled(fixedRate = 1)
    private void privateDemo() {
        System.out.println("Rien c'est privé");
    }
}
