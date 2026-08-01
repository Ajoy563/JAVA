package DP;

public class StringConversion {
    public static int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][m];
        int addOP = m - lcs;
        int deleteOP = n - lcs;

        return addOP + deleteOP;
    }
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";

        System.out.println("Minimum No. of operations: " + lcs(str1, str2));
    }
}
