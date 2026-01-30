// Check if LL is palindrome or not
public class LLIsPalindromeOrNot {
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

    public Node findMid() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;// Jump 1 node
            fast = fast.next.next; //Jump 2 node
        }
        return slow; //Mid node of LL
    }

    public boolean checkPalindrome() {
        if(head == null || head.next == null)
            return true;
        //step1 - Find Mid node
        Node midNode = findMid();

        //step2 - Reverse the 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head; //1st half of LL
        Node right = prev; //2nd half of LL

        //step3 - Compare left half vs right half
        while(right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LLIsPalindromeOrNot ll = new LLIsPalindromeOrNot();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);  //For Even values
        // ll.addLast(1);

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);  //For odd values
        ll.addLast(2);
        ll.addLast(1);

        ll.print();
        boolean result = ll.checkPalindrome();
        System.out.println(result ? "Palindrome" : "Not palindrome");
    }
}
