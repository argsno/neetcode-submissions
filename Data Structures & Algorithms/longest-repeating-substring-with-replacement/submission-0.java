class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int n = s.length();
        int left = 0, right = 0;
        int ans = 0;
        while (right < n) {
            char c = s.charAt(right);
            count[c-'A']++;
            if (valid(count, k)) {
                ans = Math.max(ans, right-left+1);
            } else {
                while (!valid(count, k)) {
                    count[s.charAt(left)-'A']--;
                    left++;
                }
            }
            right++;
        }
        return ans;
    }

    private boolean valid(int[] count, int k) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            max = Math.max(max, count[i]);
        }
        return sum - max <= k;
    }
}
