package DP;

public class UnboundedKnapsack {

    public static void printDP(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int unbounded(int val[], int wt[], int W) { //O(n * W)
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0; i<n; i++) 
            dp[i][0] = 0;
        for(int i=0; i<n; i++) 
            dp[0][i] = 0;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                //valid
                int v = val[i-1], w = wt[i-1];
                if(w <= j) { 
                    int incProfit = v + dp[i][j-w]; //may include the same item
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else { //invalid
                    int excProfit = dp[i-1][j];
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
        System.out.println("Max Profit: " + unbounded(val, wt, W));
    }
}
