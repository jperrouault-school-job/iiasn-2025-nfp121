import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApplication {
    public static void main(String[] args) {
        // Pas de doublons, mais pas d'ordre garanti
        Set<String> set1 = new HashSet<>();
        
        set1.add("A");
        set1.add("Z");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        set1.add("B");

        System.out.println(set1);

        
        // Pas de doublons, garde l'ordre
        Set<String> set2 = new LinkedHashSet<>();
        
        set2.add("A");
        set2.add("Z");
        set2.add("B");
        set2.add("C");
        set2.add("D");
        set2.add("B");

        System.out.println(set2);
    }
}