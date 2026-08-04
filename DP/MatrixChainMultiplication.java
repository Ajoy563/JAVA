package DP;

import java.util.*;

@SuppressWarnings("unused")
public class MatrixChainMultiplication {
    public static int mcmRec(int arr[], int i, int j) { //TC -> O(2^n), SC -> O(n)
        //BC
        if(i == j)
            return 0;
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int cost1 = mcmRec(arr, i, k); //Ai...Ak -> arr[i-1] X arr[k]
            int cost2 = mcmRec(arr, k+1, j); //Ak+1....Aj -> arr[k] X arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j]; // arr[i-1] X arr[k] X arr[j]
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }
        return minCost;
    }

    public static int mcmMem(int arr[], int i, int j, int dp[][]) { //TC -> O(n^3), SC -> O(n^2)
        if(i == j)
            return 0;

        if(dp[i][j] != -1) 
            return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int cost1 = mcmMem(arr, i, k, dp); //Ai....Ak -> arr[i-1] X arr[k]
            int cost2 = mcmMem(arr, k+1, j, dp); //Ak+1....Aj -> arr[k] X arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }
        return dp[i][j] = minCost;
    }

    public static int mcmTab(int arr[]) { //TC -> O(n^3), SC -> O(n^2)
        int n = arr.length;
        int dp[][] = new int[n][n];

        //Initialize
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
        }

        for(int len=2; len<=n-1; len++) {
            for(int i=1; i<=n-len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3}; //1x2 2x3 3x4 4x3
        int n = arr.length;

        // int dp[][] = new int[n][n];
        // for(int i=0; i<n; i++)
        //     Arrays.fill(dp[i], -1);

        // System.out.println("Minimum cost using Recursion is: " + mcmRec(arr, 1, n-1));
        // System.out.println("Minimum cost is using Memoization: " + mcmMem(arr, 1, n-1, dp));

        System.out.println("Minimum cost using Tabulation: " + mcmTab(arr));
    }
}
