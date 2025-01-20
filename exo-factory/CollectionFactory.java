import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CollectionFactory {
    public static <T> Collection<T> createCollection(boolean linked, boolean synchro, boolean noDuplicates) {
        Collection<T> lst = null;

        if (linked) {
            lst = (noDuplicates) ? new LinkedHashSet<>() : new LinkedList<>();
        }

        else {
            lst = (noDuplicates) ? new HashSet<>() : new ArrayList<>();
        }

        if (synchro) {
            return Collections.synchronizedCollection(lst);
        }

        return lst;
    }
}
