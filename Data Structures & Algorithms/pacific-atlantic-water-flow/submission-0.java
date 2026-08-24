class Solution {
    int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        Deque<int[]> queue2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{0, i});
            queue2.offer(new int[]{m-1, i});
        }
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
            queue2.offer(new int[]{i, n-1});
        } 
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        dfs(heights, pacific, queue);
        dfs(heights, atlantic, queue2);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }


    private void dfs(int[][] grid, boolean[][] pacific, Deque<int[]> queue) {
        int m = grid.length, n = grid[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            if (pacific[i][j]) continue;

            pacific[i][j] = true;
            for (int[] dir : dirs) {
                int di = i + dir[0];
                int dj = j + dir[1];
                if (di < 0 || di >= m || dj < 0 || dj >= n || pacific[di][dj]
                  || grid[di][dj] < grid[i][j]) {
                    continue;
                }
                queue.offer(new int[]{di, dj});
            }
        }
    }
}
