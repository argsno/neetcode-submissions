class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        int l = max, r = sum+1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (valid(weights, days, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean valid(int[] weights, int days, int cap) {
        int cur = 0;
        for (int w : weights) {
            if (cur + w > cap) {
                days--;
                cur = w;
            } else {
                cur += w;
            }
        }
        return days >= 1;
    }
}