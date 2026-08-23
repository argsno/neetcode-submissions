class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < 2*n-1; i++) {
            int l = i/2;
            int r = i/2 + i%2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
        }
        return ans;
    }
}
