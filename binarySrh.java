import java.util.Scanner;
public class binarySrh {
    public static int BinarySearch(int arr[], int lb, int ub, int x) {
        if(lb < ub) {
            int mid = lb + (ub - lb) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] > x) {
                return BinarySearch(arr, lb, mid-1, x);
            }
            else {
                return BinarySearch(arr, mid+1, ub, x);
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter Elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter element to search: ");
        int x = sc.nextInt();
        int index = BinarySearch(arr, 0, n-1, x);
        if(index == -1) {
            System.out.println("Element not found!");
        }
        else {
            System.out.println("Element found at: " + index);
        }
        sc.close();
    }
}
