package DP;

public class MinimumSumZero {
    public static boolean isSum0(int arr[]) { //O(n*W)
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++)
            sum += arr[i];
        int W = sum/2;
        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(arr[i-1] <= j) {
                    //include
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        if(sum1 == ((double)sum/2)) 
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        // int numbers[] = {1, 6, 11, 5};
        int numbers[] = {1, 2, 3};
        System.out.println("Is difference is 0: " + isSum0(numbers));
    }
}
