class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] prev = intervals[0];
        int ans = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= prev[1]) {
                prev = curr;
            } else if (curr[1] > prev[1]) {
                ans++;
            } else {
                prev = curr;
                ans++;
            }
        }
        return ans;
    }
}
