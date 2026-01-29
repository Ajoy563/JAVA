// Q) We are given a string S, we need to find the count of all contiguous 
//substrings starting and ending with same character.
// Example: S = "abcab"
// Output: 7
public class CountSubstring {
    public static int SubStrings(String str) {
        int count = 0;
        int n = str.length();
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(str.charAt(i) == str.charAt(j)) {  //Check start and end characters
                    System.out.print(str.substring(i, j+1) + " "); //print substrings
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String args[]) {
        String str = "abcab";
        int total = SubStrings(str);
        System.out.println("\nTotal Substrings is: " + total);
    }
}
