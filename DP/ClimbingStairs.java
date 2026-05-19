package DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static int countWays(int n) {  //O(2^n)
        if(n == 0)
            return 1;
        if(n<0)
            return 0;

        return countWays(n-1) + countWays(n-2);
    }
    
    public static int memoization(int n, int ways[]) {  //O(n)
        if(n == 0)
            return 1;
        if(n<0)
            return 0;

        if(ways[n] != -1)
            return ways[n];

        ways[n] = countWays(n-1) + countWays(n-2);
        return ways[n];
    }

    public static int tabulation(int n) {  //O(n)
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<dp.length; i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static void printWays(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }
        if (n < 0)
            return;
        
        printWays(n - 1, path + "1 "); //1 step
        printWays(n - 2, path + "2 "); //2 steps
    }

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];

        Arrays.fill(ways, -1); // -1 -1 -1 -1 -1 -1

        // System.out.println("Total no. of ways: " + countWays(n));
        
        // System.out.println("Total no. of ways: " + memoization(n, ways));
        
        System.out.println("Total no. of ways: " + tabulation(n));
        
        System.out.println("Ways are:");
        printWays(n, "");
    }
}
