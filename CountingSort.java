public class CountingSort {
    public static void countsort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++) { //Take the elem from the arr and 
            count[arr[i]]++;             //put it in the elem value location
        }
        int j = 0;
        for(int i=0; i<count.length; i++) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    public static void PrintArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        countsort(arr);
        PrintArray(arr);
    }
    
}
