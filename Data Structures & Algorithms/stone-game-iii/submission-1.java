class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] memo = new Integer[n+1];
        int v = dfs(stoneValue, 0, memo);
        if (v > 0) {
            return "Alice";
        } else if (v == 0) {
            return "Tie";
        } else {
            return "Bob";
        }
    }

    private int dfs(int[] stone, int cur, Integer[] memo) {
        int n = stone.length;
        if (n == cur) return memo[n] = 0;

        if (memo[cur] != null) {
            return memo[cur];
        }

        int v = Integer.MIN_VALUE;
        int curStone = 0;
        for (int i = 0; i + cur < n && i < 3; i++) {
            curStone += stone[i+cur];
            v = Math.max(v, curStone - dfs(stone, i+cur+1, memo));
        }
        return memo[cur] = v;
    }
}