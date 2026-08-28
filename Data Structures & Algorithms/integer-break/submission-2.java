class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 4; i <= n; i++) {
            int curr = Math.max(dp[1]*2, dp[0]*3);
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = curr;
        }
        return dp[2];
    }
}