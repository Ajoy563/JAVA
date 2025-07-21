public class OptimizedPower {
    public static int PowerOptimized(int x, int n) {
        if(n == 0) {
            return 1;
        }
        // if n is even 
        int halfPower = PowerOptimized(x, n/2);
        int halfPowersq = halfPower * halfPower;

        //if n is odd
        if(n % 2 != 0) {
            halfPowersq = x * halfPowersq;
        }
        return halfPowersq;

    }
    public static void main(String args[]) {
        int x = 2;
        int n = 7;
        System.out.println(PowerOptimized(x, n));
    }
}
