import java.util.List;

public class FonctionnelleApplication {
    public static void main(String[] args) {
        List<String> prenoms = List.of("Jérémy", "Evann", "Maxence", "Léo-Sélim", "Nathan", "Maxence", "Marine", "Evan");
    
        // Afficher QUE les prénoms qui commencent par la lettre E
        prenoms.stream()
            // .filter((arg) -> {
            //     return arg.startsWith("E");
            // })
            .filter(arg -> arg.startsWith("E"))

            // .map(prenom -> prenom.toUpperCase())
            .map(String::toUpperCase)

            // .forEach(prenom -> {
            //     System.out.println(prenom);
            // })

            // .forEach(prenom -> System.out.println(prenom))
            .forEach(System.out::println)
        ;
    }
}
