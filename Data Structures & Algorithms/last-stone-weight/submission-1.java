class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int n : stones) {
            pq.offer(n);
        }
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sub = n1 - n2;
            if (sub > 0) pq.offer(sub);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
