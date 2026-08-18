impl Solution {
    pub fn has_duplicate(nums: Vec<i32>) -> bool {
        let mut set = HashSet::new();

        for i in & nums {
            if (set.contains(i)) {
                return true
            } else {
                set.insert(i);
            }
        }
        false
    }
}
