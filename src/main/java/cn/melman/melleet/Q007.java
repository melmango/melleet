package cn.melman.melleet;

public class Q007 {

    public int reverse(int i) {
        double target = i;
        if (i < 0) {
            target = target * -1;
        }
        if (target < 10) {
            return i;
        }
        int index = 1;
        int res = 0;
        while (true) {
            double pow = Math.pow(10, index);
            int number = (int) ((int) (target % (Math.pow(10, index))) / Math.pow(10, index - 1));
            double temp = (double) res * 10 + (double) number;
            if (temp < Integer.MAX_VALUE) {
                res = (int) temp;
            }else{
                return 0;
            }
            index++;
            if (target < pow) {
                break;
            }
        }
        return i < 0 ? res * -1 : res;
    }

    public static void main(String[] args) {
        int res = new Q007().reverse(-2147483648);
        System.out.print(res);
    }


}
