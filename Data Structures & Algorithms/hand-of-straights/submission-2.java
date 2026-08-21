class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int h : hand) {
            countMap.merge(h, 1, Integer::sum);
        }

        for (int card : hand) {
            if (countMap.get(card) == 0) continue;

            int count = countMap.get(card);
            for (int j = 0; j < groupSize; j++) {
                if (countMap.getOrDefault(card+j, 0) < count) {
                    return false;
                }
                countMap.put(card+j, countMap.get(card+j) - count);
            }
        }

        return true;
    }
}
