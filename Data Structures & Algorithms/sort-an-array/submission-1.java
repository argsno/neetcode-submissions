class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int l = 0, r = nums.length-1;
        sort(nums, l, r);
        return nums;
    }

    void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        sort(nums, l, p-1);
        sort(nums, p+1, r);
    }

    int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, r);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}