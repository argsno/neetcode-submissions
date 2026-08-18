class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = toKey(str);
            map.computeIfAbsent(key, (k) -> new ArrayList<>()).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private String toKey(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                sb.append(i+'a');
                sb.append(counts[i]);
            }
        }
        return sb.toString();
    }
}
