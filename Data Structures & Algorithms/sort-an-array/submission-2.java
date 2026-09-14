class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int l = 0, r = nums.length-1;
        int[] aux = new int[nums.length];
        sort(nums, l, r, aux);
        return nums;
    }

    void sort(int[] nums, int l, int r, int[] aux) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;

        sort(nums, l, mid, aux);
        sort(nums, mid+1, r, aux);
        if (nums[mid] <= nums[mid+1]) return;
        merge(nums, l, mid, r, aux);
    }

    void merge(int[] a, int l, int m, int r, int[] aux) {
        System.arraycopy(a, l, aux, l, r - l + 1);
        int i = l, j = m+1, k = l;
        while (i <= m && j <= r) {
            if (aux[i] <= aux[j]) a[k++] = aux[i++];
            else a[k++] = aux[j++];
        }
        while (i <= m) a[k++] = aux[i++];
        while (j <= r) a[k++] = aux[j++];
    }
}