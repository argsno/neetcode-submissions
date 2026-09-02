class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] min = new int[n];
        int r = 1;
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int p = search(min, 0, r, nums[i]);
            min[p] = nums[i];
            if (p >= r) {
                r = p+1;
            }
        }
        
        return r;
    }

    // 查找第一个小于等于target的位置，target最大的话返回下一个位置
    // [1, 3, 5], 4 -> 2
    // [1, 3, 5], 6 -> 3
    // [9], 1 -> 0
    int search(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
