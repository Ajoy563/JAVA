public class GridWaysImplementation {
    public static long factorial(int x) {
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
    public static long countWays(int n, int m) { //Linear time O(n+m)
        // way|path = (n-1)Down and (m-1)Right

        int total = (n - 1) + (m - 1);
        long permutation = factorial(total) / (factorial(n-1) * factorial(m-1));
        return permutation;
    }

    public static int gridWays(int i, int j, int n, int m) { //O(2 ^n+m)
        //base case
        if(i == n-1 && j == m-1) {  //source - target cel
            return 1;
        }
        else if(i == m || j == n) {  //boundary cross conditions
            return 0;
        }

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);

        return w1 + w2;
    }
    public static void main(String[] args) { 
        int n = 3, m = 3;
        System.out.println("Total number of ways to reach the targeted cell is: " + countWays(n, m));
        //System.out.println("Total number of ways to reach the targeted cell is: " + gridWays(0, 0, n, m));
    }
}
