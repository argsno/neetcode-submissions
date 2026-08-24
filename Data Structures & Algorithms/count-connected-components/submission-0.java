class Solution {
    int[] parent;
    int[] size;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(size, 1);
        int ans = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                ans--;
            }
        }
        return ans;
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
