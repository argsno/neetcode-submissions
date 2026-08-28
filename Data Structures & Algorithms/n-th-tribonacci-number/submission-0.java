class Solution {
    public int tribonacci(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;
        int[] t = new int[3];
        t[1] = 1;
        t[2] = 1;
        for (int i = 3; i <= n; i++) {
            int curr = t[0] + t[1] + t[2];
            t[0] = t[1];
            t[1] = t[2];
            t[2] = curr;
        }
        return t[2];
    }
}