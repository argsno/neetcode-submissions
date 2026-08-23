class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int rob1 = rob(nums, 0, n-2);
        int rob2 = rob(nums, 1, n-1);
        return Math.max(rob1, rob2);
    }

    private int rob(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int step1 = 0;
        int step2 = 0;
        for (int i = l; i <= r; i++) {
            int curr = Math.max(nums[i] + step1, step2);
            step1 = step2;
            step2 = curr;
        }
        return step2;
    }
}
