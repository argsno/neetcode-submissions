class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c-'A']++;
        }
        int maxCount = 0;
        int numMax = 0;
        for (int c : count) {
            if (c > maxCount) {
                maxCount = c;
                numMax = 1;
            } else if (c == maxCount) {
                numMax += 1;
            }
        }

        return Math.max(tasks.length, (maxCount-1)*(n+1) + numMax);
    }
}
