class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int step1 = 0, step2 = nums[0];
        for (int i = 2; i <= n; i++) {
            int curr = Math.max(nums[i-1] + step1, step2);
            step1 = step2;
            step2 = curr;
        }
        return step2;
    }
}
