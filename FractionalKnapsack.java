//Greedy Approach

// Given the weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
    // value [60, 100, 120]
    // weight [10, 20, 30]      // ans = 240
    // W-50

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void print2DArray(double activities[][]) {
        for(int i=0; i<activities.length; i++) {
            for(int j=0; j<2; j++) {
                System.out.print(activities[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int weights[] = {10, 20, 30};
        int val[] = {60, 100, 120};
        int w = 50;

        double ratio[][] = new double[weights.length][2];
        //0th col -> index, 1st col -> ratios
        for(int i=0; i<ratio.length; i++) {
            ratio[i][0] = i; 
            ratio[i][1] = val[i]/(double)weights[i]; 
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); //ascending order

        double Total_value = 0;
        int capacity = w;
        for(int i=ratio.length-1; i>=0; i--) { //High ratio value will be at the last of array
            int idx = (int)ratio[i][0];
            if(capacity >= weights[idx]) {  //include full item
                capacity -= weights[idx];
                Total_value += val[idx];
            }
            else {  //include fractional item
                Total_value += ratio[i][1] * capacity;  //eg, 4 * 20 = 80
                capacity = 0;
                break;
            }
        }
        System.out.println("Total value of " + w + " is: " + Total_value);
    }    
}
