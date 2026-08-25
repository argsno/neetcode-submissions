class Solution {
    int[] parent;
    int[] size;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] posi = points[i];
                int[] posj = points[j];
                int dist = Math.abs(posi[0] - posj[0]) + Math.abs(posi[1] - posj[1]);
                edges.add(new int[]{i, j, dist});
            }
        }

        edges.sort((a, b) -> a[2] - b[2]);
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(size, 1);

        int cost = 0;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                cost += edge[2];
            }
        }
        return cost;
    }

    int find(int a) {
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return false;
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
        }
        return true;
    }
}
