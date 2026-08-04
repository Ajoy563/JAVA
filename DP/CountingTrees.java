package DP;
//Catalan's Number Approach
public class CountingTrees {
    public static int bstForm(int n) { //TC-> O(n^2), SC-> O(n)
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                int leftSubtree = dp[j];
                int rightSubtree = dp[i-j-1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        System.out.println("No. of BST of " + arr.length + " nodes is: " + bstForm(arr.length));
    }
}
