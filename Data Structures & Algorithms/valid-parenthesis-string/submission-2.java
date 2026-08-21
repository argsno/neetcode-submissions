class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                lo--;
                hi--;
            } else {
                lo--;
                hi++;
            }
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
        
    }
}
