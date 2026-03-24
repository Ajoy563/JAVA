//Greedy Approach
// You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can come after pair (a, b) if b < c.
// Find the longest chain which can be formed from a given set of pairs.

// pairs = (5, 24), (39,60), (5, 28), (27,40), (50, 90)
// ans = 3

import java.util.*;
public class MaxLenChainOfPairs {
    public static void print2DArray(int resultPairs[][]) {
        for(int i=0; i<resultPairs.length; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(resultPairs[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) { //O(nlogn)
        int pairs[][] = {{5, 24}, {39,60}, {5, 28}, {27,40}, {50, 90}};

        int resultPairs[][] = new int[pairs.length][3];
        //0th - index, 1st - 1st number, 2nd - 2nd number

        for(int i=0; i<pairs.length; i++) {
            resultPairs[i][0] = i; //index
            resultPairs[i][1] = pairs[i][0]; //1st number
            resultPairs[i][2] = pairs[i][1]; //2nd number
        }
        Arrays.sort(resultPairs, Comparator.comparingDouble(o -> o[2]));
        
        ArrayList<Integer> p = new ArrayList<>();
        p.add(0); //1st pair index
        int ans = 1; //select the 1st pair
        int lastEnd = resultPairs[0][2]; //Take the 2nd number of 1st pair

        for(int i=1; i<pairs.length; i++) {
            if(resultPairs[i][1] > lastEnd) { //Compare the starting no. with the lastendno.
                ans++;
                lastEnd = resultPairs[i][2]; //Update the last end
                p.add(resultPairs[i][0]); //Store the index
            }
        }
        System.out.println("Longest chains is = " + ans);
        System.out.print("Pairs are: ");
        for(int i=0; i<p.size(); i++) {
            System.out.print("P" + p.get(i) + " ");
        }
    }
}
