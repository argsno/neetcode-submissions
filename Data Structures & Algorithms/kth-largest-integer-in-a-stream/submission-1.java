class KthLargest {
    int cap;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        cap = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > cap) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > cap) {
            pq.poll();
        }
        
        return pq.peek();
    }
}
