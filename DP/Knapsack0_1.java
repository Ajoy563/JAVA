package DP;

public class Knapsack0_1 { //recursion - O(2^n)
    public static int knapsack(int val[], int wt[], int W, int n) {
        if(W == 0 || n == 0)
            return 0;

        if(wt[n-1] <= W) {
            //include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        }
        else {
            return knapsack(val, wt, W, n-1);
        }
    }
    public static int memoization(int val[], int wt[], int W, int n, int dp[][]) { //O(n)
        if(W == 0 || n == 0)
            return 0;

        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        else {
            if(wt[n-1] <= W) {
                //include
                int ans1 = val[n-1] + memoization(val, wt, W-wt[n-1], n-1, dp);
                //exclude
                int ans2 = memoization(val, wt, W, n-1, dp);
    
                dp[n][W] =  Math.max(ans1, ans2);
                return dp[n][W];
            }
            else {
                dp[n][W] =  memoization(val, wt, W, n-1, dp);
                return dp[n][W];
            }
        }
    }

    public static void printDP(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int tabulation(int val[], int wt[], int W) { //O(n)
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<n; i++)
            dp[i][0] = 0;  //0th col

        for(int i=0; i<n; i++)
            dp[0][i] = 0;  //0th row

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                int v = val[i-1], w = wt[i-1];

                if(w <= j) {
                    int incProfit = v + dp[i-1][j-w]; //valid
                    int excProfit = dp[i-1][j];  //not valid
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else {
                    int excProfit = dp[i-1][j];  //not valid
                    dp[i][j] = excProfit;
                }
            }
        }
        printDP(dp);
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        int dp[][] = new int[val.length+1][W+1];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // System.out.println("Max Profit: " + knapsack(val, wt, W, val.length));
        
        // System.out.println("Max Profit: " + memoization(val, wt, W, val.length, dp));

        System.out.println("Max Profit: " + tabulation(val, wt, W));
    }
}

