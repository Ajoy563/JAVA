import java.util.*;
public class Tickets {
    public static void main(String[] args) {
        //[[MUC, LHR], [JFK, MUC], [SFO, SJC], [LHR, SFO]]
        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );
        HashMap<String, String> map = new HashMap<>();
        for(List<String> ticket: tickets) {
            map.put(ticket.get(0), ticket.get(1));
        }
        System.out.println(map);
        HashMap<String, String> RevMap = new HashMap<>();
        for(String key : map.keySet()) {
            RevMap.put(map.get(key), key);
        }
        List<String> result = new ArrayList<>();
        String start = "";
        for(String key : map.keySet()) {
            if(!RevMap.containsKey(key)) {
                start += key;
            }
        }
        result.add(start);
        int n = map.size();
        while(n > 0) {
            result.add(map.get(start));
            start = map.get(start);
            n--;
        }
        System.out.println(result);
    }
}