class LRUCache {
    class Node {
        int key, val;
        Node prev, next;
    }
    int cap;
    Node head, tail;

    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.next.prev= node.prev;
        node.prev.next = node.next;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            addToHead(node);
            return;
        } else {
            node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addToHead(node);
        }

        if (map.size() > cap) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

    }
}
