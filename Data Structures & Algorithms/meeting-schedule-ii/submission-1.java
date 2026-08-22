/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 0) {
            return 0;
        }
        int ans = 1;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> Integer.compare(a. end, b.end));
        for (Interval interval : intervals) {
            while (!pq.isEmpty() && pq.peek().end <= interval.start) {
                pq.poll();
            }
            pq.offer(interval);
            ans = Math.max(ans, pq.size());
        }

        return ans;
    }
}
