class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void bt(int[] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            bt(nums, i+1, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}
