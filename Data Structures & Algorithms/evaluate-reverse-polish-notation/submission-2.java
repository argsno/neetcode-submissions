class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : tokens) {
            if ("+".equals(str) || "-".equals(str)
                || "*".equals(str) || "/".equals(str)) {
                int v2 = stack.pop();
                int v1 = stack.pop();
                if ("+".equals(str)) {
                    stack.push(v1 + v2);
                } else if ("-".equals(str)) {
                    stack.push(v1 - v2);
                } else if ("*".equals(str)) {
                    stack.push(v1 * v2);
                } else if ("/".equals(str)) {
                    stack.push(v1 / v2);
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
