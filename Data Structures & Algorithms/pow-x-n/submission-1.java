class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long l = n;
        if (l < 0) {
            return 1 / pow(x, -l);
        } else {
            return pow(x, l);
        }
    }

    private double pow(double x, long n) {
        if (n == 1) return x;
        double p = pow(x, n/2);
        if (n % 2 == 1) {
            return p * p * x;
        } else {
            return p * p;
        }
    }

}
