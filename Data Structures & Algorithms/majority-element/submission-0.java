class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }
}