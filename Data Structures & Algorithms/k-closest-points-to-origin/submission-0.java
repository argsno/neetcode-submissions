class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) return points;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> l2(a) - l2(b));
        int cap = points.length - k;
        int[][] ans = new int[k][2];
        int i = 0;
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > cap) {
                ans[i++] = pq.poll();
            }
        }
        return ans;
    }

    private int l2(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
