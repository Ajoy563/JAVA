package BST;

import java.util.ArrayList;

public class ConvertBSTToBalancedBST {
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

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null)
            return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(Node root, ArrayList<Integer> inorder, int st, int end) {
        if(st > end)
            return null;

        int mid = (st + end) / 2;
        root = new Node(inorder.get(mid));

        root.left = createBST(root.left, inorder, st, mid-1);;
        root.right = createBST(root.right, inorder, mid+1, end);

        return root;

    }

    public static Node balancedBST(Node root) { //O(n)
        //Inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced BST
        root = createBST(root, inorder, 0, inorder.size() - 1);

        return root;
    }
    public static void main(String[] args) {
        /*
                        8
                       / \
                      6   10
                     /      \
                    5        11
                   /          \
                  3            12
         */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        
        System.out.print("Original BST: ");
        preorder(root);

        root = balancedBST(root);
        System.out.print("\nBalanced BST: ");
        preorder(root);
        System.out.println();

        /*
                         8
                       /   \
                      5     11      <- expected BST
                    /  \   /  \
                   3    6 10   12
        */
    }
}
