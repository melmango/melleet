package cn.melman.melleet;

public class Q008 {

    public int myAtoi(String str) {

        String input = str.trim();
        if (input == null || input.length() == 0) {
            return 0;
        }
        boolean belowZero = false;
        int index = 0;
        if (input.charAt(0) == '-') {
            belowZero = true;
            index++;
        } else if (input.charAt(0) == '+') {
            index++;
        }
        long res = 0L;
        while (index < input.length()) {
            char c = input.charAt(index);
            if (c >= '0' && c <= '9') {
                res = res * 10L + (long) (c - '0');
            } else {
                break;
            }
            long i = belowZero ? -1 * res : res;
            if (i >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (i <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        long i = belowZero ? -1 * res : res;
        return (int) i;
    }

    public static void main(String[] args) {
        int res = new Q008().myAtoi("-91283472332");
        System.out.print(res);
    }

}
