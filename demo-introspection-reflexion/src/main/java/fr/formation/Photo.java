package fr.formation;

public class Photo {
    private int id;
    private String title;

    public Photo(String title) {
        this.title = title;
    }

    public void demo() {
        System.out.println("Rien");
    }

    private void privateDemo() {
        System.out.println("Rien c'est privé");
    }
}
