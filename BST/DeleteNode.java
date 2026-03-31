package BST;

public class DeleteNode {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else {
            //case 1: No child(leaf node)
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2: One child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            //case 3: Two child
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
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

    public static void inorder(Node root) {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

        inorder(root);
        System.out.println();

        delete(root, 8);
        inorder(root);
        System.out.println();
    }
}
