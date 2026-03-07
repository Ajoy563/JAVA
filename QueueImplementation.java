import java.util.*;
public class QueueImplementation {
    // static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    
    // static class QueueLL {
    //     static Node head = null;
    //     static Node tail = null;

    //     public static boolean isEmpty() {
    //         return head == null && tail == null;
    //     }

    //     public static void add(int data) {
    //         Node newNode = new Node(data);
    //         if(isEmpty()) {
    //             head = tail = newNode;
    //             return;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("Queue is empty!");
    //             return -1;
    //         }
    //         if(head.next == null) {
    //             int front = head.data;
    //             head = tail = null;
    //             return front;
    //         }
    //         int front = head.data;
    //         head = head.next;
    //         return front;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("Queue is empty!");
    //             return -1;
    //         }
    //         return head.data;
    //     }

    // }
    // static class CQueue {
    //     static int arr[];
    //     static int rear, front, size;

    //     CQueue(int n) {
    //         arr = new int[n];
    //         front = rear = -1;
    //         size = n;
    //     }

    //     public static boolean isEmpty() {
    //         return rear == -1 && front == -1;
    //     }

    //     public static boolean isFull() {
    //         return (rear + 1) % size == front;
    //     }

    //     public static void add(int data) {
    //         if(isFull()) {
    //             System.out.println("Circular queue is full!");
    //             return;
    //         }
    //         //If add 1st element
    //         if(front == -1) {
    //             front = 0;
    //         }
    //         rear = (rear + 1) % size;
    //         arr[rear] = data;
    //     }

    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("Circular Queue is empty");
    //             return -1;
    //         }
    //         int result = arr[front];
    //         if(front == rear) {
    //             front = rear = -1;
    //         } else {
    //             front = (front + 1) % size;
    //         }
    //         return result;
    //     }
    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("Circular Queue is empty");
    //             return -1;
    //         }
    //         return arr[front];
    //     }
    // }

    // static class Queue {
    //     static int arr[];
    //     static int  rear, size;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //     }

    //     public static boolean isEmpty() {
    //         return rear == -1;
    //     }
    //     public static void add(int data) {
    //         if(rear == size-1) {
    //             System.out.println("Queue is full");
    //             return;
    //         }
    //         rear++;
    //         arr[rear] = data;
    //     }

    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("Queue is Empty!");
    //             return -1;
    //         }
    //         int front = arr[0];
    //         for(int i=0; i<rear; i++) {
    //             arr[i] = arr[i+1];
    //         }
    //         rear--;
    //         return front;
    //     }
    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("Queue is Empty!");
    //             return -1;
    //         }
    //         return arr[0];
    //     }

    // }
    public static void main(String[] args) {
        // QueueLL q = new QueueLL();
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
