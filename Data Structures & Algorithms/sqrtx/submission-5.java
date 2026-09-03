class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 0, r = x/2+1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (valid(m, x)) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return l-1;
    }

    private boolean valid(int v, int x) {
        return v  <= x/v;
    }
}