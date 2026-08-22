class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int q = queries.length;
        int[] ans = new int[q];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] queryWithIndex = new int[q][2];
        for (int i = 0; i < q; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int intervalIdx = 0;
        for (int[] query : queryWithIndex) {
            int qVal = query[0];
            int qIndex = query[1];

            while (intervalIdx < n && intervals[intervalIdx][0] <= qVal) {
                int left = intervals[intervalIdx][0];
                int right = intervals[intervalIdx][1];
                int len = right - left + 1;
                minHeap.offer(new int[]{len, right});
                intervalIdx++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < qVal) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                ans[qIndex] = -1;
            } else {
                ans[qIndex] = minHeap.peek()[0];
            }
        }
        return ans;
    }
}
