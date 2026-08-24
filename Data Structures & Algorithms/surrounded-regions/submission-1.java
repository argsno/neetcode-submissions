class Solution {
    int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                visited[0][i] = true;
                queue.offer(new int[]{0, i});
            }
            if (board[m-1][i] == 'O') {
                visited[m-1][i] = true;
                queue.offer(new int[]{m-1, i});
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                visited[i][n-1] = true;
                queue.offer(new int[]{i, n-1});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int di = cur[0] + dir[0];
                int dj = cur[1] + dir[1];
                if (di < 0 || di >= m || dj < 0 || dj >= n || visited[di][dj]) continue;
                if (board[di][dj] == 'X') continue;
                visited[di][dj] = true;
                queue.offer(new int[]{di, dj});
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
