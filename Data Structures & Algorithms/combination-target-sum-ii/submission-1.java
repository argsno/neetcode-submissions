class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        bt(candidates, 0, ans, new ArrayList<>(), target);
        return ans;
    }

    private void bt(int[] nums, int index, List<List<Integer>> ans, List<Integer> curr, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) break;
            if (i != index && i > 0 && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            bt(nums, i+1, ans, curr, target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
