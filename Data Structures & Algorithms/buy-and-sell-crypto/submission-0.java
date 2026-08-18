class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int curr = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            curr += prices[i] - prices[i-1];
            ans = Math.max(ans, curr);
            if (curr < 0) curr = 0;
        }
        return ans;
    }
}
