package Easy;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 7, 5, 6, 4, 9, 8, 10};  //9 elements

        int n = arr.length + 1; // 10
        int xor1 = 0, xor2 = 0;

        for(int i=1; i<=n; i++) {
            xor1 ^= i; //1^2^3^...^10
        }
        for(int i=0; i<arr.length; i++) {
            xor2 ^= arr[i]; //1^3^2^5^6^...^10
        }
        int missingNumber = xor1 ^ xor2;

        System.out.println("The missing number is: " + missingNumber);
        
    }
}
