class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int i = 0;
        for (; i < s1.length(); i++) {
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }
        for (; i < s2.length(); i++) {
            if (equal(s1Count, s2Count)) {
                return true;
            }
            s2Count[s2.charAt(i)-'a']++;
            s2Count[s2.charAt(i-s1.length())-'a']--;
        }
        if (equal(s1Count, s2Count)) {
            return true;
        }
        return false;
    }

    private boolean equal(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
