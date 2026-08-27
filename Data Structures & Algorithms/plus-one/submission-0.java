class Solution {
    public int[] plusOne(int[] digits) {
        boolean all9 = true;
        for (int d : digits) {
            if (d != 9) {
                all9 = false;
            }
        }
        if (all9) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }

        int n = digits.length-1, carry = 1;
        while (carry > 0) {
            int sum = digits[n] + carry;
            carry = sum / 10;
            digits[n] = sum % 10;
            n--;
        }
        return digits;
    }
}
