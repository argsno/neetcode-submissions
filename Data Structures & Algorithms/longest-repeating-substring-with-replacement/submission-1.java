class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int n = s.length();
        int left = 0, right = 0;
        int ans = 0;
        int maxFreq = 0;
        while (right < n) {
            char c = s.charAt(right);
            count[c-'A']++;
            maxFreq = Math.max(maxFreq, count[c-'A']);
            if (right - left + 1 - maxFreq <= k) {
                ans = Math.max(ans, right-left+1);
            } else {
                count[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
