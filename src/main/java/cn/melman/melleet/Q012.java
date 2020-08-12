package cn.melman.melleet;

import java.util.HashMap;
import java.util.LinkedList;

public class Q012 {

    static char[] CHAR_NUM = {'C', 'X', 'I'};
    static int[] INT_NUM = {100, 10, 1};
    static char[] CHAR50_NUM = {'D', 'L', 'V'};


    public String intToRoman(int num) {
        int temp = num;
        StringBuilder sb = new StringBuilder();
        int thousand = temp / 1000;
        if (thousand > 0) {
            appendCount(thousand, 'M', sb);
            temp = temp - (thousand * 1000);
        }
        for (int i = 0; i < 3; i++) {
            int count = temp / INT_NUM[i];
            if (count > 0) {
                if (count < 4) {
                    appendCount(count, CHAR_NUM[i], sb);
                } else if (count == 4) {
                    sb.append(CHAR_NUM[i]);
                    sb.append(CHAR50_NUM[i]);
                } else if (count == 9) {
                    sb.append(CHAR_NUM[i]);
                    sb.append(i == 0 ? 'M' : CHAR_NUM[i - 1]);
                } else {
                    sb.append(CHAR50_NUM[i]);
                    appendCount(count - 5, CHAR_NUM[i], sb);
                }
                temp = temp - INT_NUM[i] * count;
            }

        }
        return sb.toString();
    }

    private void appendCount(int count, char c, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q012().intToRoman(4));
    }


}
