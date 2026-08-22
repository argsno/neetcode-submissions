class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        bt(n, 0, ans, new StringBuilder());
        return ans;
    }

    private void bt(int n, int left, List<String> ans, StringBuilder sb) {
        if (n == 0 && left == 0) {
            ans.add(sb.toString());
            return;
        }
        if (n > 0) {
            sb.append('(');
            bt(n-1, left+1, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if (left > 0) {
            sb.append(')');
            bt(n, left-1, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
