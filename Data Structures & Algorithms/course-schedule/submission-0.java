class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new HashSet<>());
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            // 0 -> null
            // 1 -> 0
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int finished = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                finished++;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Set<Integer> nexts = graph.get(cur);
            for (int next : nexts) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    finished++;
                    queue.offer(next);
                }
            }
        }
        return finished == numCourses;
    }
}
