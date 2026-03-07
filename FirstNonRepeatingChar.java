//Oueue
public class FirstNonRepeatingChar {
    public static void nonRepeat(String str) {
        int freq[] = new int[26];
        java.util.Queue<Character> q = new java.util.LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            Character ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            }
            else {
                System.out.print(q.peek() + " ");
            }
        }
    }
  public static void main(String[] args) {
    String str = "aabccxb";
    System.out.print("First non-repeating characters are: ");
    nonRepeat(str);
  }  
}
