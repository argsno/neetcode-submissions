class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = best(s, i, i);
            if (l > maxLen) {
                maxLen = l;
                start = i - l/2;
            }
            l = best(s, i, i+1);
            if (l > maxLen) {
                maxLen = l;
                start = i - l/2 + 1;
            }
        }
        return s.substring(start, start+maxLen);
    }

    private int best(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l -1;
    }
}
