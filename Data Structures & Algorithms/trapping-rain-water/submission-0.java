class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;
        int ans = 0;

        while (left < right) {
            // 比较当前高度
            if (height[left] < height[right]) {
                // 因为 height[left] < height[right]，且 right 是一路保留下来的较高点
                // 所以真正的右侧最高点一定 >= height[right] > height[left]。
                // 因此左边的水瓶颈【绝对只取决于 l_max】，不用去管右边当前的 r_max！
                if (height[left] >= l_max) {
                    l_max = height[left]; // 更新短板
                } else {
                    ans += l_max - height[left]; // 直接算，绝对不会出现负数
                }
                left++;
            } else {
                // 同理，右侧瓶颈绝对只取决于 r_max
                if (height[right] >= r_max) {
                    r_max = height[right];
                } else {
                    ans += r_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}