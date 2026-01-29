import java.util.*;
public class HashMapDemo {
    public static void HashIteration() {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 120);
        hm.put("China", 100);
        hm.put("US", 50);
        hm.put("Nepal", 20);

        Set<String> Keys = hm.keySet();
        // System.out.println(Keys);

        //Iteration
        for (String k : Keys) {
            System.out.println("Keys = " + k + ", Values = " + hm.get(k));
        }
    }
    public static void HashOperations(){
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 120);
        hm.put("China", 100);
        hm.put("US", 50);
        hm.put("Nepal", 20);
        // System.out.println(hm); 

        //Get - O(1)
        int p = hm.get("China");
        // System.out.println(p); //Display the corresponding value

        //ContainsKey - O(1)
        // System.out.println(hm.containsKey("Russia")); //Return false
        // System.out.println(hm.containsKey("US"));  //Return true

        //Remove - O(1)
        System.out.println(hm.remove("China")); //Return 100
        System.out.println(hm); //Return data except China

        //Size()
        System.out.println(hm.size()); //Length of HashMap

        //IsEmpty()
        System.out.println(hm.isEmpty()); //Return false

        //clear()
        hm.clear();
        System.out.println(hm.isEmpty()); //Return true
    }
    public static void main(String args[]) {
        // HashOperations();
        HashIteration();
    }
}
