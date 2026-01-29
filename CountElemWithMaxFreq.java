import java.util.*;
public class CountElemWithMaxFreq {
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        int maxFreq = 0;
        for(Integer i : map.values()) {
            maxFreq = Math.max(maxFreq, i);
        }
        int result = 0;
        for(Integer i : map.values()) {
            if(maxFreq == i) {
                result += i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,2,3,1,4};
        //Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
        //So the number of elements in the array with maximum frequency is 4.

        System.out.println(maxFrequencyElements(nums));
    }
}
