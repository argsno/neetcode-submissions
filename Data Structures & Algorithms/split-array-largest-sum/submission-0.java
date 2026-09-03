class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int l = max, r = sum+1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (valid(nums, k, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean valid(int[] nums, int k, int max) {
        int cur = 0;
        for (int num : nums) {
            if (cur + num > max) {
                k--;
                cur = num;
            } else {
                cur += num;
            }
        }
        return k >= 1;
    }
}