class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int step1 = cost[n-1];
        int step2 = cost[n-2];
        for (int i = n-3; i >= 0; i--) {
            int curr = Math.min(step1, step2) + cost[i];
            step1 = step2;
            step2 = curr;
        }
        return Math.min(step1, step2);
    }
}
