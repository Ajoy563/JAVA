package Easy;

public class MaxMinInArray {
    public static void main(String[] args) {
        int arr[] = {2, 4, 3, 1, 9, 6, 7, 12};
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
            smallest = Math.min(smallest, arr[i]);
        }
        System.out.println("Largest Element is: " + largest);
        System.out.println("Smallest Element is: " + smallest);
    }
}
