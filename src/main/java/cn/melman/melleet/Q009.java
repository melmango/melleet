package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class Q009 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int index = 1;
        List<Integer> list = new ArrayList<>();
        while (true) {
            double pow = Math.pow(10, index);
            int number = (int) ((int) (x % (Math.pow(10, index))) / Math.pow(10, index - 1));
            list.add(number);
            if (x < pow) {
                break;
            }
            index++;
        }
        for (int i = 0, len = (list.size() / 2); i < len; i++) {
            boolean ret = list.get(i).equals(list.get(list.size() - i-1));
            if (!ret) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Q009().isPalindrome(123321);
        System.out.print(res);
    }
}
