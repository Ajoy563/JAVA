import java.util.ArrayList;
public class HeapImplementation {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data) {
            arr.add(data);
            int child = arr.size()-1; //Child index
            int parent = (child-1)/2; //Parent position
            while(child > 0 && arr.get(child) < arr.get(parent)) { //O(logn)
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                child = parent;
                parent = (child-1)/2;
            }
            // System.out.println(arr);
        }
        public void print() {
            System.out.println(arr);
        }
        public void peek() {
            System.out.println(arr.get(0));
        }

        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;
            
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if(minIdx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            //step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - remove last element
            arr.remove(arr.size()-1);

            //step3 - heapify
            heapify(0);
            return data;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        // h.print();
        h.add(1);
        h.print();

        h.remove();
        h.print();
        // h.peek();

        
    }
}
