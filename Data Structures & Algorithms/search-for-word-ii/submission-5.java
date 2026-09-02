class Solution {
    class Trie {
        Node root = new Node();
        class Node {
            Node[] childs = new Node[26];
            String word;
        }

        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (cur.childs[c] == null) {
                    cur.childs[c] = new Node();
                }
                cur = cur.childs[c];
            }
            cur.word = word;
        }

        int[][] dirs = new int[][]{ {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        public List<String> search(char[][] board, int i, int j) {
            return search(board, root, i, j);
        }


        private List<String> search(char[][] board, Node cur, int i, int j) {
            int m = board.length, n = board[0].length;
            List<String> ans = new ArrayList<>();
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return ans;
            }
            if (board[i][j] == '-') {
                return ans;
            }
            
            char c = board[i][j];

            if (cur.childs[c-'a'] == null) return ans;
            cur = cur.childs[c-'a'];
            if (cur.word != null) {
                ans.add(cur.word);
                cur.word = null;
            }

            board[i][j] = '-';
            for (int[] dir : dirs) {
                int di = dir[0] + i;
                int dj = dir[1] + j;
                ans.addAll(search(board, cur, di, dj));
            }
            board[i][j] = c;
            return ans;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        List<String> ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans.addAll(trie.search(board, i, j));
            }
        }
        return ans;
    }
}
