class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        bt(s, 0, ans, new ArrayList<>());
        return ans;
    }

    private void bt(String s, int index, List<List<String>> ans, List<String> curr) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPali(s, index, i)) {
                String substr = s.substring(index, i+1);
                curr.add(substr);
                bt(s, i+1, ans, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPali(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
