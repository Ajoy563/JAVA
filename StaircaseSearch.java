public class StaircaseSearch {
    public static void SearchMatrix(int matrix[][], int key) {
        //Row-wise case(n-1, 0)
        int Row = matrix.length-1, Col = 0;

        while(Col < matrix[0].length && Row >=0) {
            if(key == matrix[Row][Col]) {
                System.out.println(key + " found at (" + Row + "," + Col + ")." );
                return;
            }
            else if(key < matrix[Row][Col]) {
                Row--;  //Top
            }
            else {
                Col++;  //Right
            }
        }
        // // Row-wise case(0, m-1)
        // int Row = 0, Col = matrix[0].length-1;
        // while(Row < matrix.length && Col>=0) {
        //     if(key == matrix[Row][Col]) {
        //         System.out.println(key + " found at (" + Row + "," + Col + ")." );
        //         return;
        //     }
        //     else if(key < matrix[Row][Col]) {
        //         Col--;  //Left
        //     }
        //     else {
        //         Row++;  //Bottom
        //     }
        // }
        System.out.println("Not Found");
    }
    public static void main(String args[]) {
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        int key = 33;
        SearchMatrix(matrix, key);
    }
    
}
