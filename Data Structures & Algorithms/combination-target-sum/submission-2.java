class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, 0, ans, new ArrayList<>(), target);
        return ans;
    }

    private void bt(int[] nums, int index, List<List<Integer>> ans, List<Integer> cur, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) return;
            cur.add(nums[i]);
            bt(nums, i, ans, cur, target-nums[i]);
            cur.remove(cur.size()-1);
        }
    }
}
