impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map: HashMap<i32, i32> = HashMap::new();

        for (index, &value) in nums.iter().enumerate() {
            match map.get(&(target - value)) {
                Some(&prev_index) => {
                    return vec![prev_index, index as i32]
                }
                None => {
                    map.insert(value, index as i32);
                }
            }
        }
        vec![]
    }
}
