class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            int i = left;
            // left to right
            while (i <= right) {
                ans.add(matrix[top][i]);
                i++;
            }
            top++;
            i = top;
            // top to bottom
            while (i <= bottom) {
                ans.add(matrix[i][right]);
                i++;
            }
            right--;
            i = right;
            while (top <= bottom && i >= left) {
                ans.add(matrix[bottom][i]);
                i--;
            }
            bottom--;
            i = bottom;
            while (left <= right && i >= top) {
                ans.add(matrix[i][left]);
                i--;
            }
            left++;
        }
        return ans;
    }
}
