class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
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
}
