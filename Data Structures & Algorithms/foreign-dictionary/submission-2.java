class Solution {
       public String foreignDictionary(String[] words) {
           // 1. 收集所有唯一字符
           Set<Character> chars = new HashSet<>();
           for (String w : words) {
               for (char c : w.toCharArray()) {
                   chars.add(c);
               }
           }

           // 2. 图用 Map 存，避免下标错位
           Map<Character, List<Character>> graph = new HashMap<>();
           Map<Character, Integer> indegree = new HashMap<>();
           for (Character c : chars) {
               graph.put(c, new ArrayList<>());
               indegree.put(c, 0);
           }

           // 3. 提取边
           for (int i = 0; i < words.length - 1; i++) {
               String a = words[i];
               String b = words[i + 1];
               int minLen = Math.min(a.length(), b.length());
               boolean foundDiff = false;
               for (int j = 0; j < minLen; j++) {
                   char ca = a.charAt(j);
                   char cb = b.charAt(j);
                   if (ca != cb) {
                       graph.get(ca).add(cb);
                       indegree.put(cb, indegree.get(cb) + 1);
                       foundDiff = true;
                       break;
                   }
               }
               if (!foundDiff && a.length() > b.length()) {
                   return "";
               }
           }

           // 4. BFS 拓扑排序
           Queue<Character> q = new LinkedList<>();
           for (Character c : chars) {
               if (indegree.get(c) == 0) {
                   q.offer(c);
               }
           }

           StringBuilder sb = new StringBuilder();
           while (!q.isEmpty()) {
               Character curr = q.poll();
               sb.append(curr);
               for (Character next : graph.get(curr)) {
                   indegree.put(next, indegree.get(next) - 1);
                   if (indegree.get(next) == 0) {
                       q.offer(next);
                   }
               }
           }

           return sb.length() == chars.size() ? sb.toString() : "";
       }
   }