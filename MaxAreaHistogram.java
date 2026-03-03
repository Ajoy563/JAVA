//Stack -> very important
// Givem an array of integers heights representing the histogram's bar height were the width of each bar is 1, return the area of the largest rectangle in the histogram.
// heights = [2,1,5,6,2,3]   ans = 10

import java.util.*;
public class MaxAreaHistogram {
    public static int maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next smaller right
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        //Next smaller left
        s = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = arr.length;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        
        //Calculate width - j-i-1 = nsr[i]-nsl[i]-1
        for(int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // int arr[] = {2, 1, 5, 6, 2, 3};
        int arr[] = {3, 5, 1, 2, 7, 4};
        int result = maxArea(arr);
        System.out.println("Maximum area is: " + result);
    }
}

// ==================OR========================= 

// public static int maxArea(int arr[]) {
//         Stack<Integer> stack = new Stack<>();
//         int maxArea = 0;
//         int n = arr.length;

//         for(int i = 0; i <= n; i++) {

//             int currHeight = (i == n) ? 0 : arr[i];

//             while(!stack.isEmpty() && currHeight < arr[stack.peek()]) {
//                 int height = arr[stack.pop()];

//                 int width;
//                 if(stack.isEmpty()) {
//                     width = i;
//                 } else {
//                     width = i - stack.peek() - 1;
//                 }

//                 int area = height * width;
//                 maxArea = Math.max(maxArea, area);
//             }

//             stack.push(i);
//         }

//         return maxArea;
// }