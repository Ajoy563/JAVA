//Stack Implementation
//The next greater element of some element x in an atrray is the first greater element that is to the right of x in the same array.
import java.util.*;
public class NextGreaterElement { //O(n)
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }

        System.out.print("Next greater elements: ");
        for(int i=0; i<nextGreater.length; i++) 
            System.out.print(nextGreater[i] + " ");
    }
}
