class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2*n];
        bt(n, 0, ans, 0, path);
        return ans;
    }

    private void bt(int n, int left, List<String> ans, int index, char[] path) {
        if (n == 0 && left == 0) {
            ans.add(new String(path));
            return;
        }
        if (n > 0) {
            path[index] = '(';
            bt(n-1, left+1, ans, index+1, path);
        }

        if (left > 0) {
            path[index] = ')';
            bt(n, left-1, ans, index+1, path);
        }
    }
}
