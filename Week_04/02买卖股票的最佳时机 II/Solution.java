class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int profit = 0;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            temp = prices[i] - prices[i-1];
            if(temp > 0){
                profit += temp;
            }
        }
        return profit;

    }
}