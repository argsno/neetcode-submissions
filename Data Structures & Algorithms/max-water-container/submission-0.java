class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n-1;

        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
