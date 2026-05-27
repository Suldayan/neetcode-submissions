class Solution {
    private int getMinimum(int sizeOfWindow, int[] prices) {
        int min = prices[0];
        for (int i = 0; i < sizeOfWindow; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return min;
    }

    private void debug(int buy, int sell, int profit) {
        System.out.println(String.format("Buying at: %d - Selling at: %d", buy, sell));
        System.out.println(String.format("Profit: %d", profit));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            int buy = getMinimum(i, prices);
            int sell = prices[i];
            int currentProfit = sell - buy;
            if (currentProfit > profit) {
                profit = currentProfit;
            }
            debug(buy, sell, currentProfit);
        }

        return profit;
    }
}
