package Easy;

public class StringPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        boolean flag = true;
        int n = str.length();
        for(int i=0; i<n/2; i++) {
            if(str.charAt(i) != str.charAt(n-i-1)) {
                flag = false;
                break;
            }
        }
        if(flag == true)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }   
}
