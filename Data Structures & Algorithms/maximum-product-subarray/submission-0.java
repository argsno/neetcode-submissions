class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i], Math.min(min[i-1] * nums[i], max[i-1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i-1] * nums[i], max[i-1] * nums[i]));
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
