class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int sLen = s.length(), tLen = t.length();
        int[] tCount = new int[128];
        int[] sCount = new int[128];

        int i = 0;
        for (; i < t.length(); i++) {
            sCount[s.charAt(i)]++;
            tCount[t.charAt(i)]++;
        }

        if (contains(sCount, tCount)) {
            return s.substring(0, tLen);
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0, left = 0;
        for (; i < s.length(); i++) {
            sCount[s.charAt(i)]++;
            while (contains(sCount, tCount)) {
                if (i - left + 1 < minLen) {
                    minLen = i - left + 1;
                    start = left;
                }
                sCount[s.charAt(left)]--;
                left++;                
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }

    private boolean contains(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] < c2[i]) {
                return false;
            }
        }
        return true;
    }
}
