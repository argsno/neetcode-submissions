class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
            for (int j = 0; j < i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j+1][i-1]);
                if (dp[j][i]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
