import java.util.*;
public class ItineraryFromTickets {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> RevMap = new HashMap<>();
        for(String key : tickets.keySet()) {
            RevMap.put(tickets.get(key), key);
        }
        //To find the starting point
        for(String key : tickets.keySet()) {
            if(!RevMap.containsKey(key)) {  //Check whether the key of tickets is present in
                return key;                 //RevMap or not. If not then return key
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengarulu");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);

        int n = tickets.size();
        while(n > 0) {
            System.out.print(" -> " + tickets.get(start));  //Get the corresponding start value
            start = tickets.get(start);
            n--;
        }
        System.out.println();
    }
}
