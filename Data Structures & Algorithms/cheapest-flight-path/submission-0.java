class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int round = 0; round <= k; round++) {
            int[] snapshot = dist.clone();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (snapshot[from] == INF) continue;
                dist[to] = Math.min(dist[to], snapshot[from] + price);
            }
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }
}
