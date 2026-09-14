class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, i = 0, r = n-1;
        while (i <= r) {
            if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
                i++;
            } else {
                i++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}