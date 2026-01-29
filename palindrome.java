public class palindrome {
    public static boolean IsPalindrome(String str) {
        int n = str.length();
        for(int i=0; i<n/2; i++) {
            if(str.charAt(i) != str.charAt(n-1-i)) {
                //Not a palindrome
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        String str = "racecar";
        System.out.println(IsPalindrome(str));
    }
    
}
