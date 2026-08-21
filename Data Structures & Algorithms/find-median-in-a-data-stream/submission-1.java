class MedianFinder {
    PriorityQueue<Integer> minpq = new PriorityQueue<>();
    PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (maxpq.isEmpty() || num <= maxpq.peek()) {
            maxpq.offer(num);
        } else {
            minpq.offer(num);
            maxpq.offer(minpq.poll());
        }
        while (maxpq.size() > minpq.size() + 1) {
            minpq.offer(maxpq.poll());
        }
    }
    
    public double findMedian() {
        if ((minpq.size() + maxpq.size()) % 2 == 1) {
            return maxpq.peek();
        } else {
            return (minpq.peek() + maxpq.peek()) / 2.0;
        }
    }
}
