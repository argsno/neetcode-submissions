class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxJump >= i) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }
        }
        return maxJump >= nums.length-1;
    }
}
