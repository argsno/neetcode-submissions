class Solution {
    class Node {
        int[] pos;
        int dis;
        Node(int[] p, int d) {
            pos = p;
            dis = d;
        }
    }

    int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            time = Math.max(time, cur[0]);

            if (cur[1] == m-1 && cur[2] == n-1) return time;

            for (int[] dir : dirs) {
                int di = cur[1] + dir[0];
                int dj = cur[2] + dir[1];
                if (di < 0 || di >= m || dj < 0 || dj >= n) continue;
                if (visited[di][dj]) continue;
                visited[di][dj] = true;
                queue.offer(new int[]{grid[di][dj], di, dj});
            }
        }

        return 0;
    }
}
