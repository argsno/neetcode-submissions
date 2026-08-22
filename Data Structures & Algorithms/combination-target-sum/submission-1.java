class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, 0, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    private void bt(int[] nums, int index, List<List<Integer>> ans, List<Integer> cur, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (sum+nums[i] > target) return;
            cur.add(nums[i]);
            bt(nums, i, ans, cur, sum+nums[i], target);
            cur.remove(cur.size()-1);
        }
    }
}
