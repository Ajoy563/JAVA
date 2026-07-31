package DP;

public class RodCutting {
    public static void printDP(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int rodCutting(int lengths[], int prices[], int totRod) {
        int n = prices.length;
        int dp[][] = new int[n+1][totRod+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(i ==0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i < n+1; i++) {
            for(int j=1; j < totRod+1; j++) {
                int p = prices[i-1], l = lengths[i-1];
                if(l <= j) {
                    //valid
                    int incProfit = p + dp[i][j-l];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }
                else {
                    //invalid
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        printDP(dp);
        return dp[n][totRod];
    }
    public static void main(String[] args) {
        int lengths[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totRod = 8; 

        System.out.println("Maximum profit: " + rodCutting(lengths, prices, totRod));
    }
}
