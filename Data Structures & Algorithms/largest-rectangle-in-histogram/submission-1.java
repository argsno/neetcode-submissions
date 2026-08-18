class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int n = heights.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int h = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int currH = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                ans = Math.max(ans, (right - left - 1) * currH);
            }
            stack.push(i);
        }
        return ans;
    }
}
