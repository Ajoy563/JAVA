public class CheckCycleInLL {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addLast(int data) {  //O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void Print() {  //O(n)
        Node temp = head;
        if(head == null) {
            System.out.println("LL is empty!");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static boolean IsCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;// Jump 1 node
            fast = fast.next.next; //Jump 2 node
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckCycleInLL ll = new CheckCycleInLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        tail.next = head.next.next;
        //1->2->3->4->5->6->7->8->3  cycle
        System.out.println(IsCycle());
    }
}
