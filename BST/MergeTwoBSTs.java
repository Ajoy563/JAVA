package BST;

import java.util.*;
public class MergeTwoBSTs {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null)
            return;

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end)
            return null;
        int mid  = (end + st) / 2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        //Find inorder of two BSTs
        getInorder(root1, arr1);
        getInorder(root2, arr2);

        //Merger 2 arrays
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) < arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            }
            else {
                arr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()) {
            arr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()) {
            arr.add(arr2.get(j));
            j++;
        }

        //last step - sorted array to balanced BST
        Node root = createBST(arr, 0, arr.size() -1);
        return root;
    }
    public static void main(String[] args) {
        /*
                2           9
               / \         / \
              1   4       3   12

              BST 1        BST 2
        */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /*
                            3
                          /   \
                         1     9         Final BST
                          \   / \
                           2 4   12
                          
        */

        System.out.print("BST 1: ");
        preorder(root1);

        System.out.print("\nBST 2: ");
        preorder(root2);
       
        Node root = mergeBSTs(root1, root2);
        System.out.print("\n\nFinal BST: ");
        preorder(root);
    }
}
