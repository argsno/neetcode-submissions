class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void bt(int[] nums, int index, List<List<Integer>> ans, List<Integer> cur) {
        ans.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);

            bt(nums, i+1, ans, cur);

            cur.remove(cur.size()-1);
        }
    }
}
