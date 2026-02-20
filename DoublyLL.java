public class DoublyLL {
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;

        } 
    }
    public void addMiddle(int data, int val) {
        Node newNode = new Node(data);
        Node temp = head;
        if(head.data == val) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Value not found!");
            return;
        }
        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        temp.prev = newNode;
        size++;
    } 

    public void removeFirst() {
        if(head == null) {
            System.out.println("DLL is emplt!");
            return;
        }
        if(head.next == null){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast(){
        if(head == null) {
            System.out.println("DLL is emplt!");
            return;
        }
        if(head.next == null){
            head = tail = null;
            size--;
            return;
        }
        tail.prev.next = null;
        size--;
    }

    public void removeMiddle(int val) {
        Node temp = head;
        if(head.data == val) {
            removeFirst();
            return;
        }
        if(tail.data == val) {
            removeLast();
            return;
        }
        while(temp != null && temp.data != val) {
            temp = temp.next;
        }
        if(temp == null) {
            System.out.println("Value not found!");
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
    public void reverse(){
        Node curr = head;
        Node next, prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void print() {  //O(n)
        Node temp = head;
        if(head == null) {
            System.out.println("DLL is empty!");
            return;
        }
        System.out.print("null <-> ");
        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");

    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addLast (1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();

        dll.reverse();
        dll.print();
    }
}
