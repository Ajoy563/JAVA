//Greedy Approach
// We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
// Find min no. of coins/notes to make change for a value V.
    // V = 121                          // V = 590
    // ans = 3 (100+20+1)               // ans = 4 (500+50+20+20) 

public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int V = 590;

        int balance = V;
        int ans = 0;
        StringBuilder notes = new StringBuilder("");
        for(int i=coins.length-1; i>=0; i--) { //O(n)
            if(balance >= coins[i]) {
                while (balance >= coins[i]) {
                    notes.append(coins[i]).append(" ");
                    balance -= coins[i];
                    ans++;  
                }
            }
            else if(balance == 0) {
                break;
            }
        }
        System.out.println("The no. of coins/notes needed for " + V + " is: " + ans);
        System.out.println("Notes are: " + notes);
    }
}
