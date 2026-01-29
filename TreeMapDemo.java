import java.util.*;

public class TreeMapDemo {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        System.out.println("HashMap: " + hm);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Nepal", 5);

        //In TreeMap, keys are Sorted order. O(logn)
        //We use Red-Black Trees data structure.
        //It is a self balancing tree

        System.out.println("TreeMap: " + tm);

    }
}
