public class kadane {
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
        if(flag == 0) {
            maxSum = Integer.MIN_VALUE;
            for(int i=0; i<arr.length; i++) {
                maxSum = Math.max(arr[i], maxSum);
            }
        }
        System.out.println("Maximum sum of Subarray is: " + maxSum);
    }
    public static void main(String args[]) {
        //int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr[] = {-1, -2, -3, -4};
        kadaneSubarray(arr);
    }
    
}
