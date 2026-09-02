class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (n == 1 || k == 1) return 0;
        long[] pair = new long[n-1];
        for (int i = 0; i < n-1; i++) {
            pair[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(pair);
        long min = 0, max = 0;
        for (int i = 0; i < k-1; i++) {
            min += pair[i];
            max += pair[n-2-i];
        }
        return max-min;
    }
}