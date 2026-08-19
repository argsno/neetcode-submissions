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
        Map<Node, Integer> iMap = new HashMap<>();
        List<Node> oList = new ArrayList<>();

        Node oPrev = dummy;
        int index = 0;
        Node iCurr = head;
        while (iCurr != null) {
            iMap.put(iCurr, index);
            Node oCurr = new Node(iCurr.val);
            iCurr = iCurr.next;

            oPrev.next = oCurr;
            oList.add(oCurr);
            oPrev = oPrev.next;

            index++;
        }

        iCurr = head;
        Node oCurr = dummy.next;
        while (iCurr != null) {
            if (iCurr.random != null) {
                int randomIndex = iMap.get(iCurr.random);
                oCurr.random = oList.get(randomIndex);
            }

            iCurr = iCurr.next;
            oCurr = oCurr.next;
        }

        return dummy.next;
    }
}
