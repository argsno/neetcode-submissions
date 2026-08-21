class WordDictionary {
    class Node {
        Node[] childs;
        boolean isEnd;
    }

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.childs == null) {
                curr.childs = new Node[26];
            }
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

    private boolean helper(String word, int index, Node curr) {
        for (int i = index; i < word.length(); i++) {
            if (curr.childs == null) return false;
            char c = word.charAt(i);
            if (c == '.') {
                boolean valid = false;
                for (Node child : curr.childs) {
                    if (child == null) {
                        continue;
                    }
                    if (helper(word, i+1, child)) {
                        valid = true;
                    }
                }
                return valid;
            } else {
                curr = curr.childs[c - 'a'];
                if (curr == null) {
                    return false;
                }
            }
        }
        return curr.isEnd;
    }
}
