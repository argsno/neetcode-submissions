class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new HashSet<>());
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                ans.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Set<Integer> nexts = graph.get(cur);
            for (int next : nexts) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                    ans.add(next);
                }
            }
        }
        return ans.size() == numCourses ? ans.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
