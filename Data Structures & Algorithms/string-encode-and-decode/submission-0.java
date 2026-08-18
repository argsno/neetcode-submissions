class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                if (c == '\\') {
                    sb.append("\\\\");
                } else if (c == ';') {
                    sb.append("\\;");
                } else {
                    sb.append(c);
                }
            }
            sb.append(';');
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (char c : str.toCharArray()) {
            if (found) {
                sb.append(c);
                found = false;
            } else if (c == '\\' && !found) {
                found = true;
            } else if (c == ';') {
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        return ans;
    }
}
