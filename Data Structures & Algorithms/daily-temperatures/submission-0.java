class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < t) {
                int curr = stack.pop();
                ans[curr] = i - curr;
            }
            stack.push(i);
        }
        return ans;
    }
}
