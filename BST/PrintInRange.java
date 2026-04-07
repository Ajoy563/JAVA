package BST;

public class PrintInRange {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(root.data < data) {
            root.right = insert(root.right, data);
        }
        else{
            root.left = insert(root.left, data);
        }
        return root;
    }

    public static void printRange(Node root, int k1, int k2) {
        if(root == null)
            return;

        if(root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }
        else if(root.data < k1)
            printRange(root.left, k1, k2);
        else
            printRange(root.right, k1, k2);
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        /*
                     8
                   /   \
                  5     10
                /   \     \
               3     6     11
              / \            \
             1   4            14
         */
        Node root = null;
        for (int i : values) {
            root = insert(root, i);
        }

        printRange(root, 5, 12);
        System.out.println();
    }
}
