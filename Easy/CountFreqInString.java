package Easy;

public class CountFreqInString {
    public static void countFrequency(String str) {
        int freq[] = new int[26];

        for(int i=0; i<str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++) {
            if(freq[i] != 0)
                System.out.println((char)(i + 'a') + " : " + freq[i]);
        }
    }
    public static void main(String[] args) {
        String str = "programming";
        countFrequency(str);
    }
}
