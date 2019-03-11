class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int peak = prices[0];
        int dip = prices[0];
        int profit = 0, i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length -1 && prices[i+1] <= prices[i])
                i++;
            dip = prices[i];
            
            while (i < prices.length -1 && prices[i+1] >= prices[i])
                i++;
            peak = prices[i];
            
            profit += peak - dip;
        }
        return profit;
    }
}
