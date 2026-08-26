class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]: text1 previous i chars with text2 previous j chars longest common subseq len
        // dp[i][j] = char(i) == char(j) ? dp[i-1][j-1] + 1 : dp[i-1][j-1]
        // 0 0 0 0
        // 0 1 1 1
        // 0 1 2 2
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char a = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char b = text2.charAt(j-1);
                dp[i][j] = (a == b) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}
