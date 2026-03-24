package Medium;
import java.util.*;
//The next greater element of some element x in an atrray is the first greater element that is to the right of x in the same array.
//arr = [6, 8, 0, 1, 3]
//next greater = [8, -1, 1, 3, -1]

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        //Next greater element will be right side of a particular element
        int nextGreater[] = new int[arr.length];
        
        Stack<Integer> s = new Stack<>(); //Push the index
        for(int i=arr.length-1; i>=0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1; //no greater element found
            }
            else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for(int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i] + " ");
        }
    }
}
