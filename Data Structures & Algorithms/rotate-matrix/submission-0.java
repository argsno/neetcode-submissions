class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            for (int c = r+1; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    private void flip(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                int temp = matrix[r][i];
                matrix[r][i] = matrix[r][j];
                matrix[r][j] = temp;
            }
        }
    }
}
