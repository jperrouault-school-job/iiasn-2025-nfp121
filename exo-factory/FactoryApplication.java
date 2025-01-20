import java.util.Collection;

public class FactoryApplication {
    /*
        Collection<String>
        Collection<Integer>
        Collection<Vehicule>
        …

        Les paramètres en question :
        - tableau ou chainé (par défaut, tableau)
        - synchronisé ou non (par défaut pas synchro)
        - doublons ou non (par défaut, doublons)
     */
    public static void main(String[] args) {
        Collection<String> lst = CollectionFactory.createCollection(true, true, true);
        Collection<Integer> lst2 = CollectionFactory.createCollection(false, true, false);
        Collection<Object> lst3 = CollectionFactory.createCollection(true, false, false);

        lst.add("1");
        lst.add("3");
        lst.add("2");
        lst.add("1");

        System.out.println(lst);
    }
}