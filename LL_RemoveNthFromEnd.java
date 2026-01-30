// Find & Rmenove Nth node from the end of Linked List
public class LL_RemoveNthFromEnd {
    class Node { //Creation of a node
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    int size = 0;

    // Insert in LL (addLast)
    public void addLast(int data){
        Node newnode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
        return;
    }

    public void deleteNthFromEnd(int n) {
        int iToFind = size-n;
        int i = 1;
        Node prev = head;

        if(n > size) {
            System.out.println("LL index is out of bound!!");
            return;
        }
        if(n == size) {
            head = head.next; //Remove First
            return;
        }

        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public void print() { //Print the LL
        Node temp = head;
        if(head == null) {
            System.out.println("LL is empty!");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        LL_RemoveNthFromEnd ll = new LL_RemoveNthFromEnd();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();

        ll.deleteNthFromEnd(2);
        ll.print();
    }

}