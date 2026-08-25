class Solution {
    class Edge {
        int target;
        int weight;

        public Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        for (int[] time : times) {
            graph.get(time[0]-1).add(new Edge(time[1]-1, time[2]));
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k-1, 0});
        dist[k-1] = 0;
        int finished = 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            if (visited[u]) continue;
            visited[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int newDist = dist[u] + edge.weight;
                if (newDist < dist[v]) {
                    finished++;
                    dist[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }

            }
        }

        int ans = 0;
        for (int num : dist) {
            if (num == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, num);
        }
        
        return ans;
    }
}
