class PrefixTree {
    class Node {
        Node[] childs;
        boolean isEnd;
    }

    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
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
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (curr.childs == null) {
                return false;
            }
            curr = curr.childs[c];
            if (curr == null) {
                return false;
            }
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (curr.childs == null) {
                return false;
            }
            curr = curr.childs[c];
            if (curr == null) {
                return false;
            }
        }
        return true;
    }
}
