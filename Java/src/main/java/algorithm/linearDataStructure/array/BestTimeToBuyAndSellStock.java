package algorithm.linearDataStructure.array;

public class BestTimeToBuyAndSellStock {
    public int bruteforce(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i < prices.length; i++) {
            for (int j=i+1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
    public int calDiff(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];

        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
