use std::collections::hash_map::Entry;

impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false
        }
        let mut counts = [0usize; 26];

        for byte in s.bytes() {
            counts[(byte - b'a') as usize] += 1;
        }

        for byte in t.bytes() {
            let index = (byte - b'a') as usize;
            
            if counts[index] == 0 {
                return false;
            }

            counts[index] -= 1;
        }
        true
    }
}
