class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j = i-1;
            for (; j >= 0 && nums[j] > num; j--) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = num;
        }
        return nums;
    }
}