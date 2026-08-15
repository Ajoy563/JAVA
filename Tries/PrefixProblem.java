package Tries;

import java.util.Arrays;

public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            Arrays.fill(children, null);
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void prefixSearch(String key) { //O(L)
        Node curr = root;
        for(int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx].freq == 1) {
                System.out.print(key.charAt(level) + " ");
                return;
            }
            System.out.print(key.charAt(level));
            curr = curr.children[idx];
        }
    }
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for (String w : arr) {
            insert(w);
        }

        System.out.print("Prefix are: ");
        for(int i=0; i<arr.length; i++) {
            prefixSearch(arr[i]);
        }
        
    }
}
