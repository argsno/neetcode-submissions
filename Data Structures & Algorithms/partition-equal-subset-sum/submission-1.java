class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        Arrays.sort(nums);
        int n = nums.length;
        // 0-1背包
        // dp[i][j] nums的前i个能刚好凑齐j
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = target; j >= 0; j--) {
                dp[j] = dp[j] || (j >= num && dp[j-num]);
            }
        }
        return dp[target];
    }
}
