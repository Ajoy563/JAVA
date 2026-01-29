import java.util.*;
public class PairSum1 {
    public static boolean Sum(List<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;
        System.out.println(rp);
        while(lp < rp) {
            //Case 1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            //Case 2
            if(list.get(lp) + list.get(rp) > target) {
                rp--;
            }
            //Case 3
            if(list.get(lp) + list.get(rp) < target) {
                lp++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=6; i++) {
            list.add(i);
        }
        int target = 5;
        System.out.println("Is Pair exits: " + Sum(list, target));
        
    }
}
