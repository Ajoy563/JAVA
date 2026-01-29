/*Given a "2 x n" floor and tile of size "2 x 1", count the number of ways to tile 
 the given board using the 2 x 1 tiles. (A tile can either be placed
 horizontally or vertically)
 */

public class TilingProblem {
    public static int tileproblem(int n) { //2 x n floor
        if(n == 0 || n == 1) {
            return 1;
        }
        //for vertical tiling
        int fnm1 = tileproblem(n-1);

        //for horizontal tiling
        int fnm2 = tileproblem(n-2);
        int totalWays = fnm1 + fnm2;
        return totalWays;
    }
    public static void main(String args[]) {
        System.out.println(tileproblem(4));
    }
}
