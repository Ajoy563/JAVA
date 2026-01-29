public class NumberIntoString {
    static String digits[] = {"zero", "one", "two", "three", "four", "five",
                              "six", "seven", "eight", "nine"};
    public static void Numstrings(int number) {
        String str = Integer.toString(number);
        for(int i=0; i<str.length(); i++) {
            int d = str.charAt(i) - '0';
            System.out.print(digits[d] + " ");
        }
    }
    public static void main(String args[]) {
        int n = 2019;
        Numstrings(n);
    }
}
