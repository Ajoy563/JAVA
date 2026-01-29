public class MissingNumbers {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for(Integer num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
      int nums[] = {9,6,4,2,3,5,7,0,1};
      System.out.println("Result: " + missingNumber(nums));
    }
}
