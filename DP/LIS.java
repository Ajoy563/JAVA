//Important
//Longest Increasing subsequence
package DP;
import java.util.*;

public class LIS {

    public static int lis_By_BS(int arr[]) { //TC-> O(n log n), SC-> O(n)
        ArrayList<Integer> list = new ArrayList<>();
        int index;
        for (int num : arr) {
            index = Collections.binarySearch(list, num);

            if(index < 0) {
                index = -(index + 1);

                if(index == list.size()) {
                    list.add(num);
                }
                else {
                    list.set(index, num);
                }
            }
        }
        return list.size();
    }

    public static int lis_DP(int arr[]) { //TC->O(n^2), SC->O(n)
        int n = arr.length, ans = 1;
        int dp[] = new int[n];

        Arrays.fill(dp, 1);

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lisTab(int arr1[]) { //TC->O(n^2), SC->O(n^2)
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        int arr2[] = new int[set.size()];
        int i=0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr1, arr2);
    }
    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        
        System.out.println("LIS(TC->O(n^2), SC->O(n^2)) : " + lisTab(arr));
        System.out.println("LIS(TC->O(n^2), SC->O(n)) : " + lis_DP(arr));
        System.out.println("LIS By Binary Search (TC-> O(n log n), SC-> O(n)) : " + lis_By_BS(arr));
    }
}
