class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!queue.isEmpty() && nums[queue.peekLast()] < num) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i < k-1) continue;
            ans[i-k+1] = nums[queue.peekFirst()];
            if (ans[i-k+1] == nums[i-k+1]) {
                queue.pollFirst();
            }
        }
        return ans;
    }
}
