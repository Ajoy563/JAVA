package BST;

public class SearchBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }  

        if(root.data < val) {
            root.right = insert(root.right, val);
        }
        else
            root.left = insert(root.left, val);

        return root;
    }

    public static void inorder(Node root) {
        if(root == null) 
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static boolean search(Node root, int key) {
        if(root == null)
            return false;

        if(root.data == key)
            return true;

        if(root.data < key)
            return search(root.right, key);
        else 
            return search(root.left, key);
    }

    public static void main(String[] args) {
        int values[] = {3, 7, 1, 9, 2, 10, 4, 6, 5, 8};
        /*
                     3
                   /   \
                  1     7
                   \   /  \
                   2  4     9
                       \   / \
                        6  8  10
                       /
                      5
         */
        Node root = null;
        for (int i : values) {
            root = insert(root, i);
        }

        inorder(root);
        System.out.println();

        int key = 11;
        if(search(root, key))
            System.out.println(key + " is present in BST");
        else
            System.out.println("Not found");
    }    
}
