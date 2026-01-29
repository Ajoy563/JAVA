import java.util.*;
public class SubArraySumEqualToK {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        // int arr[] = {1,2,3};
        // int k = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //initially we have to add this

        int sum = 0, ans = 0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Subarray Sum equal to K = " + ans);
    }
}
