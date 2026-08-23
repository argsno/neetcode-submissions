class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int n = s.length();

        int prev2 = 1;
        int prev1 = 1;
        for (int i = 1; i < n; i++) {
            int cur = 0;
            if (s.charAt(i) != '0') {
                cur += prev1;
            }
            int twoDigit = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                cur += prev2;
            }
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
