class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        Arrays.sort(nums);
        int n = nums.length;
        // dp[i]: i 能通过nums凑齐
        // 0-1背包
        // dp[i][j] nums的前i个能刚好凑齐j
        boolean[][] dp = new boolean[n+1][target+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = target; j >= 0; j--) {
                dp[i][j] = dp[i-1][j] || (j >= num && dp[i-1][j-num]);
            }
        }
        return dp[n][target];
    }
}
