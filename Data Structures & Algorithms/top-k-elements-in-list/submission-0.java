class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) {
            pq.offer(key);
        }

        int[] ans = new int[k];
        while (k-- > 0) {
            ans[k] = pq.poll();
        }
        return ans;
    }
}
