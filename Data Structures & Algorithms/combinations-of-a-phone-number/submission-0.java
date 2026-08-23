class Solution {
    private static final String[] map = new String[] {
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        
        bt(digits, 0, ans, new char[digits.length()]);
        return ans;
    }

    private void bt(String digits, int index, List<String> ans, char[] curr) {
        if (digits.length() == index) {
            ans.add(new String(curr));
            return;
        }
        String chars = map[digits.charAt(index)-'2'];

        for (int i = 0; i < chars.length(); i++) {
            curr[index] = chars.charAt(i);
            bt(digits, index+1, ans, curr);
        }
    }

}
