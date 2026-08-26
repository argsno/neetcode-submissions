class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] a = new int[n+2];
        System.arraycopy(nums, 0, a, 1, n);
        a[0] = a[n+1] = 1;

        int[][] dp = new int[n+2][n+2];
        for (int len = 2; len <= n+1; len++) {
            for (int i = 0; i + len <= n+1; i++) {
                int j = i + len;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + a[i] * a[k] * a[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
