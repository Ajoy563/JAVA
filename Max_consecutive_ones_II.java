public class Max_consecutive_ones_II {
    public static int Solution(int nums[]) {
        int i=0, j=0, max=0, zeros=0;
        while (i < nums.length) {
            if(nums[i] == 0) {
                zeros++;
            }
            while (zeros == 2) {
                if(nums[j] == 0) {
                    zeros--;
                }
                j++;
            }
            max = Math.max(max, i - j + 1);
            i++;
        }
        return max;
    }
    public static void main(String[] args) {
        int nums[] = {1, 0, 0, 1, 1, 0, 1};
        System.out.println("Max_consecutive_ones: " + Solution(nums));
    }
}
