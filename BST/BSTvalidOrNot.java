package BST;

public class BSTvalidOrNot {
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

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null)
            return true;

        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root)
        && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        // int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        int values[] = {1,1,1};
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

        if(isValidBST(root, null, null)) 
            System.out.println("Valid BST");
        else 
            System.out.println("Invalid BST");
        System.out.println();
    }
}
