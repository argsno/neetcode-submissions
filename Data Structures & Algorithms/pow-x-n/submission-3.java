class Solution {
    public double myPow(double x, int n) {
        long l = n;
        if (l < 0) {
            x = 1/x;
            l = -l;
        }
        double r = 1.0;
        while (l > 0) {
            if ((l & 1) == 1) {
                r *= x;
            }
            x *= x;
            l >>= 1;
        }
        return r;
    }

}
