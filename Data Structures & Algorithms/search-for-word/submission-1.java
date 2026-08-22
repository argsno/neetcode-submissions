class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && bt(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1} };

    private boolean bt(char[][] board, int i, int j, int index, String word) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];
            if (bt(board, di, dj, index+1, word)) {
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
