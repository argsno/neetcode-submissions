class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int sold = Integer.MIN_VALUE;
        int hold = -prices[0];
        int rest = 0;
        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, rest - prices[i]);
            int newSold = hold + prices[i];
            int newRest = Math.max(rest, sold);
            hold = newHold;
            sold = newSold;
            rest = newRest;
        }
        return Math.max(sold, rest);
    }
}
