package Graphs;

public class FloodFillAlgo {
    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
        //base case
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
           || vis[sr][sc] || image[sr][sc] != orgCol) {
            //image[sr][sc] != orgCol -> if there is 0 or other color
            return;
           }

        vis[sr][sc] = true;
        image[sr][sc] = color;

        //left
        helper(image, sr, sc-1, color, vis, orgCol);
        //right
        helper(image, sr, sc+1, color, vis, orgCol);
        //up
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr+1, sc, color, vis, orgCol);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void printArr(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            for(int j = 0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) { //O(m*n)
        int image[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, color = 2;
        System.out.println("Original Array: ");
        printArr(image);
        floodFill(image, sr, sc, color);

        System.out.println("After color change: ");
        printArr(image);

        
    }
}

