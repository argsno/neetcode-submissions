class Solution {
    int[][] dirs = new int[][] { {0,1}, {0,-1}, {1,0}, {-1,0} };
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == 0) queue.offer(new int[]{i, j});
        
        int curr = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int di = pos[0] + dir[0];
                    int dj = pos[1] + dir[1];
                    if (di < 0 || di >= m || dj < 0 || dj >= n) continue;
                    if (grid[di][dj] == Integer.MAX_VALUE) {
                        grid[di][dj] = curr;
                        queue.offer(new int[]{di, dj});
                    }
                }
            }
            curr++;
        }
    }
}
