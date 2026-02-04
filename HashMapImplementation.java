import java.util.LinkedList;
import java.util.ArrayList;
public class HashMapImplementation {
    static class HashMap<K,V> { //K and V be any datatype, create by programmar
        private class Node { 
            K key;
            V value;

            public Node(K key, V value) {  //LL keys and values
                this.key = key;
                this.value = value;
            }
        }
        private int n = 0;  //No. of key,value pair
        private int N; //buckets.length
        private LinkedList<Node> buckets[];  //Like Array

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;  //bucket size
            this.buckets = new LinkedList[4];
            for(int i=0; i<N; i++) {
                this.buckets[i] = new LinkedList<>();  //create a LL in every idx positions
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();  //generate code name to every data
            return Math.abs(hc) % N;  //give correct bucket index position as per the data
        }

        private int SearchInLL(K key, int bi) {  //search the data in LL, return idx pos
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for(int i=0; i<ll.size(); i++) { //Search for a particular key
                Node node = ll.get(i);  //fetch the key,value pair
                if(node.key == key) {
                    return di;  //key idx found
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() { //when the no. of node becomes more
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<buckets.length; i++) { //Overwrite the size of buckets
                buckets[i] = new LinkedList<>();  //Create more LL in every idx pos
            }
            for(int i=0; i<oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];  //Every idx, no. of LL
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();  //Store the pairs
                    put(node.key, node.value);  //Put in the new Buckets of N
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); //0 to 3 of bucket index
            int di = SearchInLL(key, bi);   //either exist or -1 in data index

            if(di != -1) {  //Exist
                Node node = buckets[bi].get(di);  
                node.value = value;
            }
            else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lamda = (double) n/N;
            if(lamda > 2.0) {
                rehash();
            }
        }

        public boolean containskey(K key) {
            int bi = hashFunction(key); 
            int di = SearchInLL(key, bi);   

            if(di != -1) {
                return true;
            }
            else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key); 
            int di = SearchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key); 
            int di = SearchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
        System.out.println(hm.containskey("China"));
    }
}
