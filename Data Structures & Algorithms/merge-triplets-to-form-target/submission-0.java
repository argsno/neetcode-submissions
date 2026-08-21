class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr = new int[3];

        for (int[] tri : triplets) {
            if (tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]) {
                continue;
            }
            curr[0] = Math.max(tri[0], curr[0]);
            curr[1] = Math.max(tri[1], curr[1]);
            curr[2] = Math.max(tri[2], curr[2]);
        }
        return curr[0] == target[0] && curr[1] == target[1] && curr[2] == target[2];
    }
}
