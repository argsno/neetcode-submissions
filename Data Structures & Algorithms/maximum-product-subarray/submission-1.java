class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prevMin = nums[0];
        int prevMax = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            int min = Math.min(nums[i], Math.min(prevMin * nums[i], prevMax * nums[i]));
            int max = Math.max(nums[i], Math.max(prevMin * nums[i], prevMax * nums[i]));
            prevMin = min;
            prevMax = max;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
