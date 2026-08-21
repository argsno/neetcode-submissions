class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] count = new int[1001];
        for (int h : hand) {
            count[h]++;
        }
        for (int i = 0; i < count.length; ) {
            if (count[i] == 0) {
                i++;
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                if (count[i+j] == 0) return false;
                count[i+j]--;
            }
        }
        return true;
   }
}
