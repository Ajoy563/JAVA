public class StockBS {
    public static int BuyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(buyPrice < prices[i]) {
                int Profit = prices[i] - buyPrice;  //Today's profit
                maxProfit = Math.max(Profit, maxProfit);  //Maximum profits
            }
            else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int p = BuyAndSellStocks(prices);
        System.out.println("Maximum Profits is: " + p);
    }
    
}
