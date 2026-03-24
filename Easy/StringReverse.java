package Easy;
//Reverse a string without using built-in function.
public class StringReverse {
    public static void main(String[] args) {
        String str = "programming";
        char arr[] = str.toCharArray();
        int n = arr.length;
        for(int i=0; i<n/2; i++) {
            char temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        String reversed = new String(arr);

        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + reversed);
        
    }
}
