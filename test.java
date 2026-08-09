
import java.util.*;

public class test {
    
        public static void main(String args[]){
        //[[MUC, LHR], [JFK, MUC], [SFO, SJC], [LHR, SFO]]
        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : tickets) {
            map.put(list.get(0), list.get(1));
        }
        HashMap<String, String> Revmap = new HashMap<>();
        for (String list : map.keySet()) {
            map.put(map.get(list), list);
        }

        ArrayList<String> ans = new ArrayList<>();
        String start = "";
        for(String key : map.keySet()) {
            if(!Revmap.containsKey(key)) {
                start += key;
            }
        }
        ans.add(start);
        int n = map.size();
        while(n > 0) {
            ans.add(map.get(start));
            start = map.get(start);
            n--;
        }
        System.out.println(ans);
    }
}
