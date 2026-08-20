class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length-1;
        quickselect(nums, lo, hi, k-1);
        return nums[k-1];
    }

    private void quickselect(int[] nums, int lo, int hi, int k) {
        int p = partition(nums, lo, hi);
        if (p == k) {
            return;
        } else if (p < k) {
            quickselect(nums, p+1, hi, k);
        } else {
            quickselect(nums, lo, p-1, k);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int index = lo + (int)(Math.random() * (hi - lo + 1));
        swap(nums, index, hi);
        int pivot = nums[hi];
        int i = lo-1;
        for (int j = lo; j < hi; j++) {
            if (nums[j] >= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i+1, hi);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
