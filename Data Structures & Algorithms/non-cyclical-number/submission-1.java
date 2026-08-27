class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int curr = 0;
            while (n > 0) {
                int mod = n % 10;
                curr += mod * mod;
                n /= 10;
            }
            if (curr == 1) return true;
            n = curr;
        }
        return false;
    }
}
