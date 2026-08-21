class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int star = 0;

        int right = 0, rstar = 0;
        for (int i = 0; i < s.length(); i++) {
            char rc = s.charAt(s.length() - i - 1);
            if (rc == ')') {
                right++;
            } else if (rc == '*') {
                rstar++;
            } else {
                if (rstar == 0 && right == 0) {
                    return false;
                } else if (right > 0) {
                    right--;
                } else {
                    rstar--;
                }
            }

            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == '*') {
                star++;
            } else {
                if (left == 0 && star == 0) {
                    return false;
                } else if (left > 0) {
                    left--;
                } else {
                    star--;
                }
            }
        }
        return star >= left && rstar >= right;
    }
}
