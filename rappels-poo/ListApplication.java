import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListApplication {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        List<String> list3 = new Vector<>(); // Thread-safe, Array

        // ou bien

        List<String> list4 = Collections.synchronizedList(new ArrayList<>()); // Thread-safe

        // ou bien encore .. mais ne sera pas stocké en tant que liste Thread-safe

        synchronized (list1) {

        }

        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("B");

        System.out.println(list1);
    }
}
