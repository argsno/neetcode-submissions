class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    int[][] dirs = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1} };

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != '1') return;

        grid[i][j] = '#';
        for (int[] dir: dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];
            dfs(grid, di, dj);
        }

    }
}
