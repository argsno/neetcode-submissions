class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) return memo[i][j];

        int ans = 1;
        for (int[] dir : dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];
            if (di < 0 || di >= matrix.length || dj < 0 || dj >= matrix[0].length
              || matrix[di][dj] <= matrix[i][j]) continue;

            ans = Math.max(ans, dfs(matrix, di, dj, memo) + 1);
        }
        memo[i][j] = ans;
        return ans;
    }
}
