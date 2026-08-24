class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) continue;
                ans = Math.max(ans, area(grid, i, j));
            }
        }
        return ans;
    }

    int[][] dirs = new int[][] { {0,1}, {0,-1}, {1,0}, {-1,0} };

    private int area(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }

        int curr = 1;
        grid[i][j] = -1;
        for (int[] dir : dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];
            curr += area(grid, di, dj);
        }
        return curr;
    }
}
