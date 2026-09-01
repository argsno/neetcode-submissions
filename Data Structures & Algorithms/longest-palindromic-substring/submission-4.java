class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, start = 0;
        for (int i = 1; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j+1][i-1]);
                if (dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
