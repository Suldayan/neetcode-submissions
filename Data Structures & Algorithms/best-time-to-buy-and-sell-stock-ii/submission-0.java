class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int totalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            final int curr = prices[i];
            final int currProfit = curr - min;

            if (curr < min) {
                min = curr;
            } else {
                totalProfit += currProfit;
                min = curr;
            }
        }

        return totalProfit;
    }
}