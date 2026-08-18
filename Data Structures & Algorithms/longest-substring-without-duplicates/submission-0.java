class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int ans = 0;
        int[] count = new int[128];

        int n = s.length();
        int right = 0, left = 0;
        while (right < n) {
            count[s.charAt(right)]++;
            if (count[s.charAt(right)] == 1) {
                ans = Math.max(ans, right - left + 1);
            } else {
                while (count[s.charAt(right)] > 1) {
                    count[s.charAt(left)]--;
                    left++;
                }
            }
            right++;
        }
        return ans;
    }
}
