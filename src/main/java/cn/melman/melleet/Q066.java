package cn.melman.melleet;

public class Q066 {

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (true) {
            int s = digits[index] + 1;
            if (s > 9) {
                digits[index] = 0;
                if (index == 0) {
                    int[] res = new int[digits.length + 1];
                    System.arraycopy(digits, 0, res, 1, digits.length);
                    res[0] = 1;
                    return res;
                }
            } else {
                digits[index] = s;
                return digits;
            }
            index--;
        }
    }
}
