
public class test {
    public static void main(String[] args) {
        // QueueLL q = new QueueLL();
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
