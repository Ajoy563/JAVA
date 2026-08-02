package DP;
//HARD LEVEL, LEETCODE = 44
public class WildcardMatching {
    public static boolean isMatching(String s, String p) { //TC-> O(n*m), SC-> O(n*m)
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        //Initialize
        dp[0][0] = true;

        //p = " "
        for(int i=1; i<n+1; i++) {
            dp[i][0] = false;
        }

        //s = " "
        for(int j=1; j<m+1; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        //bottom up
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                //case 1
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    boolean ign = dp[i][j-1];
                    boolean match = dp[i-1][j];
                    dp[i][j] = ign || match;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        // String s = "baaabab";
        // String p = "*****ba*****ab";
        String s = "abc";
        String p = "**?b*";

        System.out.println("String == Pattern: " + isMatching(s, p));
    }
}
