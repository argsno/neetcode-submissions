class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                ans.add(interval);
            } else if (interval[0] > newInterval[1]) {
                break;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        ans.add(newInterval);
        for (; i < intervals.length; i++) {
            ans.add(intervals[i]);
        }
        return ans.toArray(new int[0][]);
    }
}
