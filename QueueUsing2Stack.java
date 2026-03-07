//Queue
// import java.util.*;
public class QueueUsing2Stack {
    static class Stack {
        static java.util.Queue<Integer> q1 = new java.util.LinkedList<>();
        static java.util.Queue<Integer> q2 = new java.util.LinkedList<>();

        public static boolean isEmpty() { //O(1)
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) { //O(1)
            if(!q1.isEmpty())
                q1.add(data);
            else 
                q2.add(data);
        }

        public static int pop() {
            if(isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = -1;
            //case 1
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            else { //case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = -1;
            //case 1
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }
            else { //case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    // static class Queue {
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     public static boolean isEmpty() { //O(1)
    //         return s1.isEmpty();
    //     }

    //     public static void add(int data) { //O(n)
    //         while (!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);

    //         while (!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }
    //     public static int remove() { //O(1)
    //         if(s1.isEmpty()) {
    //             System.out.println("Queue is empty!");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
    //     public static int peek() { //O(1)
    //         return s1.peek();
    //     }

    // }
    public static void main(String[] args) {
        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
         while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
         }
    }
}
