class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(piles, mid, h)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean valid(int[] piles, int k, int h) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += (piles[i] + k - 1) / k;
        }
        return count <= h;
    }
}
