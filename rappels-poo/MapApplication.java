import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapApplication {
    public static void main(String[] args) {
        // Clé, valeur
        // Pas de doublons sur les clés, pas d'ordre garanti
        Map<String, String> map1 = new HashMap<>();

        map1.put("A", "A");
        map1.put("Z", "Z");
        map1.put("B", "B");
        map1.put("C", "C");
        map1.put("D", "D");
        map1.put("B", "E");
        map1.put("E", "A");

        System.out.println(map1);

        // Pas de doublons sur les clés, avec ordre
        Map<String, String> map2 = new LinkedHashMap<>();

        map2.put("A", "A");
        map2.put("Z", "Z");
        map2.put("B", "B");
        map2.put("C", "C");
        map2.put("D", "D");
        map2.put("B", "E");
        map2.put("E", "A");

        System.out.println(map2);
    }
}
