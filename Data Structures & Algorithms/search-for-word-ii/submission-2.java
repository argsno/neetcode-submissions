class Solution {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    class Node {
        Node[] childs = new Node[26];
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            addWord(root, word);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, ans);
            }
        }
        return ans;
    }

    private void search(char[][] board, int i, int j, Node parent, List<String> ans) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') {
            return;
        }
        char c = board[i][j];
        Node curr = parent.childs[c-'a'];
        if (curr == null) return;
        if (curr.word != null) {
            ans.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];
            search(board, di, dj, curr, ans);
        }
        board[i][j] = c;
    }

    private void addWord(Node curr, String word) {
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.childs[c] == null) {
                curr.childs[c] = new Node();
            }
            curr = curr.childs[c];
        }
        curr.word = word;
    }
}
