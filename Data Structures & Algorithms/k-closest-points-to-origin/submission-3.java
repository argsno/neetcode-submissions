class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(points, 0, points.length-1, k-1);
        return Arrays.copyOf(points, k);
    }

    private void quickselect(int[][] pts, int lo, int hi, int k) {
        while (lo < hi) {
            int mid = partition(pts, lo, hi);
            if (mid == k) return;
            else if (mid < k) lo = mid + 1;
            else hi = mid - 1;
        }
    }

    private int partition(int[][] pts, int lo, int hi) {
        swap(pts, lo + (int)(Math.random() * (hi - lo + 1)), hi); // 随机枢轴换到 hi
        int pivot = l2(pts[hi]);
        int i = lo - 1;
        for (int j = lo; j < hi; j++)
            if (l2(pts[j]) <= pivot) swap(pts, ++i, j);
        swap(pts, i + 1, hi); // 枢轴元素落到返回位置
        return i + 1;
    }

    private void swap(int[][] pts, int i, int j) {
        int[] p = pts[i];
        pts[i] = pts[j];
        pts[j] = p;
    }

    private int l2(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
