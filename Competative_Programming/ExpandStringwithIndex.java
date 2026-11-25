package Competative_Programming;

//Cognizant Coding Pdf - Q1
public class ExpandStringwithIndex {
    public static String expandString(String input) {
        StringBuilder result = new StringBuilder("");
        int firstIdx[] = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int idx = ch - 'a';

            if (firstIdx[idx] == 0) {
                firstIdx[idx] = i + 1;
            }

            if (i > 0) {
                result.append("-");
            }

            int repeatCount = firstIdx[idx];
            for (int j = 0; j < repeatCount; j++) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abcaba";
        String output = expandString(input);
        System.out.println(output);
    }
}
