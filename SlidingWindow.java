// PriorityQueue/Heap
// Maximum of all Subarrays of size K
import java.util.*;
public class SlidingWindow {
    static class Pair implements Comparable<Pair> {
        int val, idx;
        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(Pair p2) {
            // return this.val - p2.val; //For ascending order

            // for decending order
            return p2.val - this.val;
        }
    }
    public static void main(String[] args) {  //O(nlogk)
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3, n = arr.length;
        int res[] = new int[n - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        for(int i=k; i<n; i++) { 
            while (pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));

            res[i-k+1] = pq.peek().val;
        }
        System.out.print("Maximum of all Subarrays is: ");
        for(int i=0; i<res.length; i++)
            System.out.print(res[i] + " ");
        
        
        
    }
}
