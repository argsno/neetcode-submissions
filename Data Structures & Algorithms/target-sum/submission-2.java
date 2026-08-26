class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum || (sum + target) % 2 == 1) return 0;
        target = (sum + target) / 2;

        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= num) {
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][target];
    }
}
