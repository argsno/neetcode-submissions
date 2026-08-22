class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // 【剪枝 1】长度压制：如果单词长度超过了网格的总容量，绝不可能放下，直接 false
        if (word.length() > m * n) {
            return false;
        }

        // 统计网格中所有字符的出现频率 (假设字符集为 ASCII)
        int[] boardCounts = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardCounts[board[i][j]]++;
            }
        }

        // 【剪枝 2】词频校验：遍历 word 字符，如果网格里根本凑不齐需要的字符，直接 false
        int[] wordCounts = new int[128];
        for (char c : word.toCharArray()) {
            wordCounts[c]++;
            if (wordCounts[c] > boardCounts[c]) {
                return false; // 原料不足，直接提前宣告失败
            }
        }

        char[] wordArray = word.toCharArray();
        // 【剪枝 3】动态选起点：对比 word 首尾字符在网格中的频率。
        // 如果尾字母出现的次数比首字母少，我们就把单词反过来搜！
        // 比如搜 "AAAAAB"，B 只有 1 个，A 有 50 个。反过来搜 "BAAAAA" 能极大减少搜索树的分支。
        if (boardCounts[wordArray[0]] > boardCounts[wordArray[wordArray.length - 1]]) {
            reverse(wordArray);
        }

        // 核心回溯逻辑保持不变
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordArray[0] && backtrack(board, i, j, 0, wordArray)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 辅助方法：反转字符数组
    private void reverse(char[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private boolean backtrack(char[][] board, int i, int j, int index, char[] word) {
        if (board[i][j] != word[index]) {
            return false;
        }

        if (index == word.length - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        for (int[] dir : DIRS) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            if (nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length) {
                if (backtrack(board, nextI, nextJ, index + 1, word)) {
                    return true;
                }
            }
        }

        board[i][j] = temp;
        return false;
    }
}