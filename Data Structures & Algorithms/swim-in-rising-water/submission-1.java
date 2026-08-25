class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = Math.max(grid[0][0], grid[n-1][n-1]);
        int hi = n * n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canReach(grid, mid)) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }

    int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    private boolean canReach(int[][] grid, int h) {
        int n = grid.length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n-1 && cur[1] == n-1) return true;
            for (int[] dir : dirs) {
                int di = cur[0] + dir[0];
                int dj = cur[1] + dir[1];
                if (di < 0 || di >= n || dj < 0 || dj >= n) continue;
                if (visited[di][dj]) continue;
                if (grid[di][dj] > h) continue;

                visited[di][dj] = true;
                queue.offer(new int[]{di, dj});
            }
        }
        return false;
    }
}
