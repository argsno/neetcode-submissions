class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }
        boolean[] diag1 = new boolean[2*n-1];
        boolean[] diag2 = new boolean[2*n-1];
        boolean[] cols = new boolean[n];
        solve(n, 0, cols, diag1, diag2, board, ans);
        return ans;
    }

    private void solve(int n, int row, boolean[] cols, 
        boolean[] diag1, boolean[] diag2, char[][] board, 
        List<List<String>> ans) {
        if (row == n) {
            ans.add(build(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;
            if (diag1[d1] || diag2[d2] || cols[col]) {
                continue;
            }
            board[row][col] = 'Q';
            diag1[d1] = true;
            diag2[d2] = true;
            cols[col] = true;
            solve(n, row+1, cols, diag1, diag2, board, ans);
            board[row][col] = '.';
            diag1[d1] = false;
            diag2[d2] = false;
            cols[col] = false;
        }
    }

    private List<String> build(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }
}
