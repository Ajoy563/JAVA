//Stack
// Given a balanced expression, find if it contains duplicate parentheses or not. A set of parentheses are duplicate if the same subexpression is surrounded by multiple parentheses.Return a true if it contains duplicates else return false.

// example: (((a+(b)))+(c+d))     true
// example: ((((a)+(b))+c+d))     true
// example: ((a+b)+(c+d))         false

import java.util.*;
public class DuplicateParentheses {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch != ')') {
                s.push(ch);
            }
            else {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                s.pop();
                if(count < 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b)+(c+d)) ";
        System.out.print("Valid Duplicate: " + isValid(str));
        
    }
}
