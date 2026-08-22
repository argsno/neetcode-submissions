class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] < curr[0]) {
                ans.add(prev);
                prev = curr;
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        ans.add(prev);
        return ans.toArray(new int[0][]);
    }
}
