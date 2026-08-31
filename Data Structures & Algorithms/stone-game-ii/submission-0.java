class Solution {
    int[] suffix;
    int[][] memo;
    int n;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        this.n = n;
        suffix = new int[n+1];
        for (int i = n-1; i >= 0; i--) suffix[i] = suffix[i+1] + piles[i];
        memo = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (i == n) return 0;
        if (i + 2*m >= n) return memo[i][m] = suffix[i];
        if (memo[i][m] != -1) return memo[i][m];

        int best = 0;
        for (int x = 1; x <= 2*m; x++) {
            int nxt = i + x;
            int opponent = dfs(nxt, Math.max(m, x));
            int cur = suffix[i] - opponent;
            if (cur > best) best = cur;
        }
        return memo[i][m] = best;
    }
}