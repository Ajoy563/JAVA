//Calculate height, count, sum and diameter of a tree.
package Trees;

public class TreeAggregates { //O(n)
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info {
        int diam, ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) { //O(n)
        if(root == null)
            return new Info(0, 0);

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), (leftInfo.ht + rightInfo.ht + 1));
        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        
        return new Info(diam, height);
    }

    public static int diameter(Node root) {  //O(N^2)
        if(root == null)
            return 0;

        int leftDiam = diameter(root.left);
        int rightDiam = diameter(root.right);
        int leftHt = height(root.left);
        int rightHt = height(root.right);

        int self = leftHt + rightHt + 1;
        return Math.max(self, Math.max(rightHt, leftHt));
    }

    public static int sum(Node root) {  //O(n)
        if(root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int count(Node root) {  //O(n)
        if(root == null)
            return 0;
        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount + rightCount + 1;
    }

    public static int height(Node root) {
        if(root == null) 
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
    public static void main(String[] args) {
        /*      1
               / \
              2   3
             / \ / \
            4  5 6  7 
        */
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

       System.out.println("Height of tree = " + height(root));
       System.out.println("Number of nodes = " + count(root));
       System.out.println("Sum of nodes = " + sum(root));
       System.out.println("Diameter of nodes O(N^2) = " + diameter(root));
       System.out.println("Diameter of nodes O(n) = " + diameter2(root).diam);
    }
}
