/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(0);
        Map<Node, Node> iMap = new HashMap<>();

        Node oPrev = dummy;
        Node iCurr = head;
        while (iCurr != null) {
            Node oCurr = new Node(iCurr.val);

            oPrev.next = oCurr;
            oPrev = oPrev.next;

            iMap.put(iCurr, oCurr);
            iCurr = iCurr.next;
        }

        iCurr = head;
        Node oCurr = dummy.next;
        while (iCurr != null) {
            oCurr.random = iMap.get(iCurr.random);

            iCurr = iCurr.next;
            oCurr = oCurr.next;
        }

        return dummy.next;
    }
}
