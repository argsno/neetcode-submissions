class CountSquares {
    int m = 1001;
    int[][] matrix = new int[m][m];

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        matrix[x][y]++;
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;
        for (int i = 1; i < m; i++) {
            int dx = x + i;
            int dy = y + i;
            if (dx < m && dy < m) {
                int cur = 1;
                cur *= matrix[x][dy];
                cur *= matrix[dx][y];
                cur *= matrix[dx][dy];
                ans += cur;
            }
            dx = x - i;
            dy = y - i;
            if (dx >= 0 && dy >= 0) {
                int cur = 1;
                cur *= matrix[x][dy];
                cur *= matrix[dx][y];
                cur *= matrix[dx][dy];
                ans += cur;
            }
            dx = x + i;
            dy = y - i;
            if (dx < m && dy >= 0) {
                int cur = 1;
                cur *= matrix[x][dy];
                cur *= matrix[dx][y];
                cur *= matrix[dx][dy];
                ans += cur;
            }
            dx = x - i;
            dy = y + i;
            if (dx >= 0 && dy < m) {
                int cur = 1;
                cur *= matrix[x][dy];
                cur *= matrix[dx][y];
                cur *= matrix[dx][dy];
                ans += cur;
            }
        }
        return ans;
    }
}
