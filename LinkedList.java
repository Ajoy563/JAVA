

public class LinkedList {
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

    public void addFirst(int data) { //O(1)
        //Step 1 - Create node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head; //link
        head = newNode;
    }

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
    public void addMiddle(int data, int idx) {  //O(n)
        if(idx == 0) {
            addFirst(data);
            return;
        }

        Node ptr = head;
        int i=0;
        while(i < idx-1) {
            i++;
            ptr = ptr.next;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = ptr.next;
        ptr.next = newNode;
    }

    public int removeFirst() {  //O(1)
        int val = 0;
        if(size == 0) {
            System.out.println("LL is empty!!!");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {  //O(n)
        int val = 0;
        if(size == 0) {
            System.out.println("LL is empty!!!");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int i = 0;
        Node ptr = head;
        while(i < size - 2) {
            ptr = ptr.next;
            i++;
        }
        val = tail.data;
        ptr.next = null;
        tail = ptr;
        size--;
        return val;
    }

    public int removeMiddle(int idx) {  //O(n)
        int val = 0;
        if(size == 0) {
            System.out.println("LL is empty!!!");
            return Integer.MIN_VALUE;
        }
        Node ptr = head;
        int i = 0;
        if(i == idx) {
            return removeFirst();
        }
        while(i < idx - 1) {
            ptr = ptr.next;
            i++;
        }
        val = ptr.next.data;
        ptr.next = ptr.next.next;
        size--;
        return val;
    }

    public int Search(int data) {  //O(n)
        Node temp = head;
        int idx = 0;
        while(temp != null) {
            if(temp.data == data) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
            return -1;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        //Add First -> O(1)
        ll.addFirst(2);
        ll.addFirst(1);

        //Add Last -> O (1)
        ll.addLast(3);
        ll.addLast(4);

        //Add middle -> O(n)
        ll.addMiddle(9, 2);
        ll.Print();

        //Print LL size -> O(n)
        // System.out.println(ll.size); //O(1)

        //Remove First -> O(1)
        // ll.removeFirst();
        // ll.Print();

        //Remove Last -> O(n)
        // System.out.println(ll.removeLast());
        // ll.Print();

        //Remove Middle -> O(n)
        // System.out.println(ll.removeMiddle(2));
        // ll.Print();

        //Search Element -> O(n)
        // System.out.println("Element Position: " + ll.Search(9));
        // System.out.println("Element Position: " + ll.Search(10));

        //Reverse LL -> O(n)
        ll.reverse();
        ll.Print();

    }
}
