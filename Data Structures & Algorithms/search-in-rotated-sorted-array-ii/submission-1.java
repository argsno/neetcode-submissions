class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) return true; 
            if (nums[m] > nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                for (int i = l; i <= r; i++) {
                    if (nums[i] == target) {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
}