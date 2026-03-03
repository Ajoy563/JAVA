import java.util.ArrayList;
public class StackByArrayList {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        int top = -1;
        public static boolean isEmpty() {
            return list.size() == 0;
        }
        public void push(int val) {
            list.add(val);
        }
        public int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() -1);
            list.remove(list.size() -1);
            return top;
        }
        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size() -1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(s.isEmpty()); 
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Stack Top: " + s.peek());
        s.pop();
        System.out.println("Stack Top: " + s.peek());

    }
}
