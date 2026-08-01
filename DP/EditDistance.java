package DP;

public class EditDistance {
    public static int editDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        //Initialize
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                }
                if(j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                //same
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else { //diff
                    int add = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) { // TC-> O(n*m), SC-> O(n*m)
        String word1 = "intention";
        String word2 = "execution";

        System.out.println("Minimum No. of Operations: " + editDistance(word1, word2));
    }
}
