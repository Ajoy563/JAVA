import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueDemo {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // This object will give the decending order
        pq.add(3);
        pq.add(5); //O(logn)
        pq.add(6);
        pq.add(1);
        pq.add(9);
        pq.add(2);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(logn)
        }
    }
}
