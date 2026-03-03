import java.util.*;
public class ReverseStrByStac {  //O(n)
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder res = new StringBuilder("");
        while (!s.isEmpty()) {
            res.append(s.pop());           
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String str = "Photosynthesis";
        String result = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reverse String: " + result);
    }
}
