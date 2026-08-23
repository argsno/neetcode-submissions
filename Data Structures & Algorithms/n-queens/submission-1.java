class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        solve(ans, queens, n, 0, 0, 0, 0);
        return ans;
    }

    private void solve(List<List<String>> ans, int[] queens, int n, int row,
        int cols, int diag1, int diag2) {
        if (n == row) {
            ans.add(build(queens));
            return;
        }

        int availPos = ((1 << n) - 1) & (~(cols | diag1 | diag2));
        while (availPos != 0) {
            int pos = availPos & (-availPos);
            availPos = availPos & (availPos-1);
            int col = Integer.bitCount(pos-1);
            queens[row] = col;
            solve(ans, queens, n, row+1, cols|pos, (diag1|pos)<<1, (diag2|pos)>>1);
            queens[row]=-1;
        }
    }

    private List<String> build(int[] queens) {
        int n = queens.length;
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
