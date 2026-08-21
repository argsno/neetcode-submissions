class WordDictionary {
    class Node {
        Node[] childs = new Node[26];;
        boolean isEnd;
    }

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.childs[c] == null) {
                curr.childs[c] = new Node();
            }
            curr = curr.childs[c];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int i, Node curr) {
        if (curr == null) return false;
        if (i == word.length()) return curr.isEnd;
        char c = word.charAt(i);
        if (c != '.') {
            Node next = curr.childs[c-'a'];
            return helper(word, i+1, next);
        }
        for (Node child : curr.childs) {
            if (helper(word, i+1, child)) {
                return true;
            }
        }
        return false;
    }
}
