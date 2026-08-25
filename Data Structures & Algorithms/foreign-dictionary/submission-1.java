class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                graph.computeIfAbsent(c, (k) -> new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        int n = words.length;
        for (int i = 1; i < n; i++) {
            String a = words[i-1], b = words[i];
            int len = Math.min(a.length(), b.length());
            boolean foundDiff = false;
            for (int j = 0; j < len; j++) {
                char ca = a.charAt(j);
                char cb = b.charAt(j);
                if (ca == cb) continue;
                foundDiff = true;
                // ca -> cb
                if (graph.get(ca).add(cb)) {
                    indegree.put(cb, indegree.get(cb) + 1);
                }
                break;
            }
            if (!foundDiff && a.length() > b.length()) return "";
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> en : indegree.entrySet()) {
            if (en.getValue() == 0) queue.offer(en.getKey());
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for (char next : graph.get(ch)) {
                indegree.put(next, indegree.get(next)-1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
