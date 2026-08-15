package Array;
public class kadane {

    public static void kadane2(int arr[]) {
        int max = arr[0], curr = arr[0];
        for(int i=1; i<arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            max = Math.max(curr, max);
        }
        System.out.println("Maximum sum of Subarray is: " + max);
    }
    public static void kadaneSubarray(int arr[]){
        int flag = 0;
        int CurrSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) {
                flag = 1;
            }
            CurrSum = CurrSum + arr[i];
            if(CurrSum < 0) {
                CurrSum = 0;
            }
            maxSum = Math.max(CurrSum, maxSum);
        }
        if(flag == 0) { //Means every elem is < 0, negative value
            maxSum = Integer.MIN_VALUE;
            for(int i=0; i<arr.length; i++) {
                maxSum = Math.max(arr[i], maxSum);
            }
        }
        System.out.println("Maximum sum of Subarray is: " + maxSum);
    }
    public static void main(String args[]) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // int arr[] = {-1, -2, -3, -4};
        // kadaneSubarray(arr);

        kadane2(arr);
    }
    
}
