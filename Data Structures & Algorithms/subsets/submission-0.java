class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, 0, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    private void bt(int[] nums, int index, boolean[] visited, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            bt(nums, i, visited, cur, ans);
            cur.remove(cur.size()-1);
            visited[i] = false;
        }
    }
}
