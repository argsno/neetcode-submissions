class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            graph.computeIfAbsent(u, (k) -> new PriorityQueue<>()).offer(v);
        }
        LinkedList<String> route = new LinkedList<>();
        dfs(graph, "JFK", route);
        return route;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String s, LinkedList<String> route) {
        PriorityQueue<String> nexts = graph.get(s);
        while (nexts != null && !nexts.isEmpty()) {
            String next = nexts.poll();
            dfs(graph, next, route);
        }
        route.addFirst(s);
    }
}
