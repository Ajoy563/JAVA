package BST;

import java.util.ArrayList;

public class PrintRootToLeaf {
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

    public static void printPath(ArrayList<Integer> path) {
        for (Integer i : path) {
            System.out.print(i + " -> ");
        }
        System.out.println("NULL");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        //base case
        if(root == null)
            return;

        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
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

        printRoot2Leaf(root, new ArrayList<>());
        System.out.println();
    }
}
