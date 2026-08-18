class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < 9; i++) {
            int[] rowCounts = new int[9];
            int[] colCounts = new int[9];
            int[] boxCounts = new int[9];
            for (int j = 0; j < 9; j++) {
                char rc = board[i][j];
                if (rc != '.') {
                    if (rowCounts[rc - '1'] > 0) {
                        return false;
                    }
                    rowCounts[rc - '1']++;
                }

                char cc = board[j][i];
                if (cc != '.') {
                    if (colCounts[cc - '1'] > 0) {
                        return false;
                    }
                    colCounts[cc - '1'] ++;
                }

                int br = (i / 3) * 3 + j / 3;
                int bc = (i % 3) * 3 + j % 3;
                char c = board[br][bc];
                if (c != '.') {
                    if (boxCounts[c - '1'] > 0) {
                        return false;
                    }
                    boxCounts[c - '1']++;
                }
            }
        }
        return true;
    }
}
