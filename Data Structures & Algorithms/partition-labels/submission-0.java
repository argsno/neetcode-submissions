class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)-'a'] = i;
        }

        int start = -1;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            end = Math.max(end, last[c]);
            if (i >= end) {
                ans.add(end-start);
                start = i;
                end = i+1;
            }
        }
        return ans;
    }
}
