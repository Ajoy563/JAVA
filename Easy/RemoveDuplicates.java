package Easy;
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        
        //If array is sorted

        // int arr[] = {1,1,2,2,3,4,4,5};
        // int index = 0;

        // for(int i=1; i<arr.length; i++) {
        //     if(arr[i] != arr[index]) {
        //         index++;
        //         arr[index] = arr[i];
        //     }
        // }
        // for(int i=0; i<=index; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        //If array is unsorted
        
        int arr[] = {2, 5, 6, 2, 3, 9, 7, 3, 1, 2};
        HashSet<Integer> h = new HashSet<>();
        for (int i : arr) {
            h.add(i);
        }
        
        for (Integer num : h) {
            System.out.print(num + " ");
        }
    }
}
