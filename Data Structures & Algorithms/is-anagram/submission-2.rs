use std::collections::hash_map::Entry;

impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false
        }
        let mut counts = [0i32; 26];

        for byte in s.bytes() {
            counts[(byte - b'a') as usize] += 1;
        }

        for byte in t.bytes() {
            let index = (byte - b'a') as usize;
            counts[index] -= 1;
            if counts[index] < 0 {
                return false;
            }
        }
        true
    }
}
