package DP;

public class LongestCommonSubstring {
    public static int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        int count = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    count = Math.max(count, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";

        System.out.println("Longest common Substring: " + lcs(s1, s2));
    }
}
