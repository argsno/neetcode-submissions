use std::collections::hash_map::Entry;

impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        if s.len() != t.len() {
            return false
        }
        let mut map = HashMap::new();
        for c in s.chars() {
            *map.entry(c).or_insert(0) += 1;
        }

        for c in t.chars() {
            match map.entry(c) {
                Entry::Occupied(mut entry) => {
                    let old = entry.insert(entry.get()-1);
                    if old == 0 {
                        return false;
                    }
                },
                _ => {
                    return false
                }
            }
        }

        for (key, value) in map {
            if value != 0 {
                return false
            }
        }


        return true
    }
}
