class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        Set<String> set = new HashSet<>();
        for (String word : wordList) set.add(word);
        if (!set.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) continue;
                        chars[i] = c;
                        String str = new String(chars);
                        if (endSet.contains(str)) return step+1;
                        if (visited.contains(str)) continue;
                        if (!set.contains(str)) continue;
                        nextSet.add(str);
                        visited.add(str);
                    }
                    chars[i] = orig;
                }
            }
            beginSet = nextSet;
            step++;
        }
        return 0;
    }
}
