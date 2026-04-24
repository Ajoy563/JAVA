package BST;

public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }
    public static Node root;

    public static int height(Node root) {
        if(root == null)
            return 0;

        return root.height;
    }

    public static int getBalance(Node root) {
        if(root == null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node leftRotation(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        //update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y; //New root
    }
    public static Node rightRotation(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return x;
        
    }

    public static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(key > root.data) {
            root.right = insert(root.right, key);
        }
        else if(key < root.data) {
            root.left = insert(root.left, key);
        }
        else
            return root; //Duplicate key is not allowed

        //update the root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        //get root's balance factor bf
        int bf = getBalance(root);

        //left left case
        if(bf > 1 && key < root.left.data) {
            return rightRotation(root);
        }

        //right right case
        if(bf < -1 && key > root.right.data) {
            return leftRotation(root);
        }

        //left right rotation
        if(bf > 1 && key > root.left.data) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        //right left rotation
        if(bf < -1 && key < root.right.data) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root; //returned if AVL is already balanced
    }

    public static void preorder(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void main(String[] args) {
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 25);
        root = insert(root, 30);
        root = insert(root, 22);
        root = insert(root, 50);

        /*
                            25
                          /    \
                         20     40       AVL Tree
                        /  \   /  \
                      10   22 30   50
         */

        System.out.print("AVL Tree Preorder: ");
        preorder(root);
    }
}
