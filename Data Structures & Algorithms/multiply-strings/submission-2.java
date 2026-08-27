class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String ans = "0";
        String suffix0 = "";
        for (int i = num2.length()-1; i >= 0; i--) {
            String temp = multiplyOne(num1, num2.charAt(i));
            ans = add(ans, temp + suffix0);
            suffix0 += "0";
        }
        return ans;
    }

    public String multiplyOne(String num1, char c) {
        int b = c - '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        while (i >= 0 || carry > 0) {
            int a = 0;
            if (i >= 0) a = num1.charAt(i) - '0';
            int res = a * b + carry;
            carry = res / 10;
            sb.append(res % 10);
            i--;
        }
        return sb.reverse().toString();
    }

    public String add(String num1, String num2) {
        int l1 = num1.length()-1, l2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0 || carry > 0) {
            int a = 0;
            if (l1 >= 0) a = num1.charAt(l1--) - '0';
            int b = 0;
            if (l2 >= 0) b = num2.charAt(l2--) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        return sb.reverse().toString();
    }
}
