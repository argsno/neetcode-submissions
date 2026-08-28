class Solution {
    public String minWindow(String s, String t) {
        int ans = Integer.MAX_VALUE;
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int needKind = 0;
        for (int v : need) if (v != 0) needKind++;

        int[] window = new int[128];

        int valid = 0;
        int left = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            while (valid == needKind) {
                if (i - left + 1 < ans) {
                    ans = i - left + 1;
                    start = left;
                }
                char d = s.charAt(left);
                if (need[d] > 0 && window[d] == need[d]) {
                    valid--;
                }
                window[d]--;
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start+ans);

    }
}
