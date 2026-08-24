class Solution {
    int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            while (size-- > 0) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1];
                if (i < 0 || i >= m || j < 0 || j >= n) continue;
                for (int[] dir : dirs) {
                    int di = i + dir[0];
                    int dj = j + dir[1];
                    if (di < 0 || di >= m || dj < 0 || dj >= n || grid[di][dj] != 1) continue;
                    grid[di][dj] = 2;
                    fresh--;
                    hasRotten = true;
                    queue.offer(new int[] {di, dj});
                }
            }
            if (hasRotten) {
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}
