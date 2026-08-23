class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] dp = precompute(s);
        bt(s, 0, dp, ans, new ArrayList<>());
        return ans;
    }

    private boolean[][] precompute(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1]);
            }
        }
        return dp;
    }

    private void bt(String s, int index, boolean[][] dp, List<List<String>> ans, List<String> curr) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                String substr = s.substring(index, i+1);
                curr.add(substr);
                bt(s, i+1, dp, ans, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}
