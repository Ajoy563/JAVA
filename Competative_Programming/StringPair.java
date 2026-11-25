/* Problem Description One person hands over the list of digits to Mr. String, But Mr. String understands only strings. Within strings also he understands only vowels. Mr. String needs your help to find the total number of pairs which add up to a certain digit D.The rules to calculate digit D are as follow :- Take all digits and convert them into their textual representation. Next, sum up the number of vowels i.e. {a, e, i, o, u} from all textual representation. This sum is digit D Now, once digit D is known find out all unordered pairs of numbers in input whose sum is equal to D. Refer example section for better understanding.

Constraints 1 <= N <= 100 1 <= value of each element in second line of input <= 100 Number 100, if and when it appears in input should be converted to textual representation as hundred and not as one hundred. Hence number of vowels in number 100 should be 2 and not 4

Input First line contains an integer N which represents number of elements to be processed as input Second line contains N numbers separated by space

Output Lower case representation of textual representation of number of pairs in input that sum up to digit D Note: – (If the count exceeds 100 print "greater 100")

Examples
Input : 5
1 2 3 4 5
Output : one

Step 1 & 2 (Find D):
1 -> "one" -> 2 vowels (o, e)
2 -> "two" -> 1 vowel (o)
3 -> "three" -> 2 vowels (e, e)
4 -> "four" -> 2 vowels (o, u)
5 -> "five" -> 2 vowels (i, e)
Total D = 2 + 1 + 2 + 2 + 2 = 9

Step 3 (Find pairs summing to 9):
Checking [1, 2, 3, 4, 5] for pairs adding to 9: only (4, 5) works (4 + 5 = 9).
Total pairs = 1.

Step 4 (Output): 1 in lowercase text -> one

Input : 3
7 4 2
Output : zero */
package Competative_Programming;

import java.util.*;

public class StringPair {
    public static void Pairs(int nums[]) {
        HashMap<Integer, String> map = new HashMap<>();
        String words[] = { "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"
        };
        String tens[] = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

        map.put(100, "hundred");
        for (int i = 0; i < 20; i++) {
            map.put(i, words[i]);
        }
        int j = 0;
        for (int i = 20; i < 91; i += 10) {
            map.put(i, tens[j]);
            j++;
        }

        String vowels = "aeiouAEIOU";
        int total_D = 0;
        for (int n : nums) {
            String word;
            if (map.get(n) == null) {
                String o = map.get(n % 10);
                String t = map.get((n / 10) * 10);
                word = t + o;
            } else {
                word = map.get(n);
            }
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (vowels.indexOf(ch) != -1) {
                    count++;
                }
            }
            total_D += count;
        }

        // // Sliding Window pattern
        // int k = 2, pairs = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        // int curr = nums[i] + nums[k + i - 1];
        // if (curr == total_D)
        // pairs++;
        // }

        // Find pairs
        HashMap<Integer, Integer> p = new HashMap<>();
        for (int n : nums) {
            p.put(n, p.getOrDefault(n, 0) + 1);
        }

        int pairs = 0;
        for (int n : nums) {
            int curr = total_D - n;
            if (p.get(curr) != null && p.get(curr) > 0) {
                pairs++;
                p.put(n, p.get(n) - 1);
            }
        }

        System.out.println(map.get(pairs));
    }

    public static void main(String[] args) {
        // int arr[] = { 11, 12, 13, 14, 36, 51, 81, 94 };
        // int arr[] = { 1, 2, 3, 4, 5 };
        int arr[] = { 1, 5, 5 };
        Pairs(arr);
    }
}
