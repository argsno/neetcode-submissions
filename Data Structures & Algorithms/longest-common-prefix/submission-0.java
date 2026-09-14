class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }

        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}