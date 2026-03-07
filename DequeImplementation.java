import java.util.*;
import java.util.LinkedList;
public class DequeImplementation {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1); //1
        d.addFirst(2); //2 1
        d.addLast(3); //2 1 3
        d.addLast(4); //2 1 3 4
        System.out.println(d);

        // d.removeFirst(); //1 3 4
        // d.removeLast(); //1 3
        // System.out.println(d);

        System.out.println(d.getFirst());
        System.out.println(d.getLast());
    }
}
