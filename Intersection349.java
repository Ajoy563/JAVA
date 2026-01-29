import java.util.*;
class Intersection349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums1) {
            set.add(i);
        }
        HashSet<Integer> result = new HashSet<>();
        for(Integer i : nums2) {
            if(set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }
        int resultset[] = new int[result.size()];
        int i = 0;
        for(Integer num : result) {
            resultset[i++] = num;
        }
        return resultset; 
    }
    public static void main(String[] args) {
        int nums1[] = {7,3,9};
        int nums2[] = {6,3,9,2,9,4};
        int result[] = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }
}