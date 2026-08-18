class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = toKey(str);
            map.computeIfAbsent(key, (k) -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String toKey(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c-'a']++;
        }
        StringBuilder key = new StringBuilder(52);
        for (int count : counts) {
            key.append('#').append(count);
        }
        return key.toString();
    }
}
