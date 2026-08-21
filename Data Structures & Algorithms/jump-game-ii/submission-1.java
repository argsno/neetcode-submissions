class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int jumps = 0;
        int curEnd = 0;
        int curFarthend = 0;
        for (int i = 0; i < n-1; i++) {
            curFarthend = Math.max(curFarthend, i + nums[i]);
            if (curFarthend >= n-1) break;
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthend;
            }
        }
        return jumps+1;
    }
}
