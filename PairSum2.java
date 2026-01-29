import java.util.*;
public class PairSum2 {
    public static boolean Sum(List<Integer> list, int target) {
        int n = list.size();
        int lp = 0, rp = 0;
        for(int i=0; i<n-1; i++) {
            if(list.get(i) > list.get(i + 1)) {
                rp = i;
                lp = i + 1;
            }
        }

        while(lp != rp) {
            //Case 1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            //Case 2
            if(list.get(lp) + list.get(rp) > target) {
                rp = (n + rp -1) % n;
            }
            //Case 3
            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        
        int target = 16;
        System.out.println("Is Pair exits: " + Sum(list, target));
        
    }
}
