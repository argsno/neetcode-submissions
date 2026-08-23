class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int len = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) continue;
                if (j - i < 2 || dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (j-i+1 > len) {
                        len = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+len);
    }
}
