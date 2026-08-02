package DP;
import java.util.*;

public class CatalansNumber {
    public static int catalanRec(int n) { //TC-> O(2^n), SC O(n)
        //BC
        if(n == 0 || n == 1) 
            return 1;

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanRec(i) * catalanRec(n-i-1);
        }

        return ans;
    }

    public static int catalanMem(int n, int dp[]) { //TC-> O(n^2), SC-> O(n)
        //BC
        if(n == 0 || n == 1) 
            return 1;

        if(dp[n] != -1) 
            return dp[n];

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
        }

        dp[n] = ans;
        return dp[n];
    }

    public static int catalanTab(int n) { //TC-> O(n^2), SC-> O(n)
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Catalan Using Recursion O(2^n): " + catalanRec(n));
        System.out.println("Catalan Using Memoization O(n^2): " + catalanMem(n, dp));
        System.out.println("Catalan Using Tabulation O(n^2): " + catalanTab(n));
    }
}
