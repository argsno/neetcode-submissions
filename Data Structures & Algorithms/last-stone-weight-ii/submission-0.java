class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int stone : stones) {
            for (int v = target; v >= stone; v--) {
                dp[v] = dp[v] || dp[v-stone];
            }
        }
        int w = target;
        while (w >= 0 && !dp[w]) w--;
        return sum - 2 * w;
    }
}