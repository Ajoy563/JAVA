package DP;
//based on 0-1 knapsack

public class TargetSum {
    public static void printDP(boolean dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean subsetSum(int nums[], int sum) { // O(n * Tsum)
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0; i<dp.length; i++)
            dp[i][0] = true;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                //include 
                int v = nums[i-1];
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        printDP(dp);
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int nums[] = {4, 2, 7, 1, 3};
        int targetSum = 10;
        System.out.println("Is subset exist: " + subsetSum(nums, targetSum));
    }
}
