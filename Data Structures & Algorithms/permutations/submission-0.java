class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        bt(nums, 0, ans, new ArrayList<>(), visited);
        return ans;
    }

    private void bt(int[] nums, int index, List<List<Integer>> ans, List<Integer> cur,
    boolean[] visited) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            bt(nums, i, ans, cur, visited);
            visited[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
