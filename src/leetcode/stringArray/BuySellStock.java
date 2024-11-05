package leetcode.stringArray;

public class BuySellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = prices[0];
        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else {
                profit = Math.max(profit, price - lowestPrice);
            }
        }
        return profit;
    }
}
