package cn.melman.melleet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Melman
 * @date 2021/3/27 3:36 PM
 */
public class Q224 {
//    int pos = 0;

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
//        pos = 0;
        int res = doCalc(s, len);
        return res;
    }


    //TODO 优化点，把preCalc和reverse合成一个1或者-1，就解决了是加还是减的问题了！
    private int doCalc(String s, int len) {
        Deque<Character> calcQueue = new LinkedList<>();
        int tempRes = 0, temp = 0;
        char preCalc = ' ';
        boolean reverse = false;
        for (int pos = 0; pos < len; pos++) {
            char c = s.charAt(pos);
            if (c == '(') {
                //往里扔符号
                calcQueue.push(preCalc);
                if (preCalc == '-') {
                    reverse = !reverse;
                }
                preCalc = '+';
            } else if (c == ')') {
                //往外扔符号
                if (temp > 0) {
                    tempRes = calcNumber(preCalc, tempRes, temp, reverse);
                    temp = 0;
                }
                preCalc = '+';
                Character poll = calcQueue.poll();
                if (poll != null && poll.charValue() == '-') {
                    reverse = !reverse;
                }
            } else if (c == ' ') {
                //这里代表数字的结束，但是也无所谓，别的地方有处理
                continue;
            } else if (Character.isDigit(c)) {
                //TODO 这里可以优化成如果发现一个数字，就直接内循环到最后一个数字
                temp = appendNumber(temp, c);
            } else {
                //已经判断了数字和空格，就一定是符号了
                if (preCalc == ' ') {//之前没有操作呗
                    tempRes = temp;
                    temp = 0;
                    preCalc = c;
                } else {
                    tempRes = calcNumber(preCalc, tempRes, temp, reverse);
                    temp = 0;//算完了，清temp
                    preCalc = c;
                }
            }
        }
        if (temp > 0) {
            tempRes = calcNumber(preCalc, tempRes, temp, reverse);
        }
        return tempRes;
    }


//递归的方法，没有跑通，突然发现没有必要，就没调
//    private int doCalcDiGui(String s, int len) {
//        int tempRes = 0, temp = 0;
//        char preCalc = ' ';
//        while (pos < len) {
//            char c = s.charAt(pos);
//            pos++;
//            if (c == '(') {
//                temp = doCalc(s, len);
//                tempRes = calcNumber(preCalc, tempRes, temp);
//                temp = 0;//算完了，清temp
//                preCalc = c;
//            } else if (c == ')') {
//                return tempRes;
//            } else if (c == ' ') {
//                //这里代表数字的结束，但是也无所谓，别的地方有处理
//                continue;
//            }
//            if (isNumber(c)) {
//                temp = appendNumber(temp, c);
//            } else {
//                //已经判断了数字和空格，就一定是符号了
//                if (preCalc == ' ') {//之前没有操作呗
//                    tempRes = temp;
//                    temp = 0;
//                    preCalc = c;
//                } else {
//                    tempRes = calcNumber(preCalc, tempRes, temp);
//                    temp = 0;//算完了，清temp
//                    preCalc = c;
//                }
//            }
//        }
//        if (temp > 0) {
//            tempRes = calcNumber(preCalc, tempRes, temp);
//        }
//        return tempRes;
//    }
//

    private int calcNumber(char c, int res, int temp, boolean reverse) {
        switch (c) {
            case '+':
                return reverse ? res - temp : res + temp;
            case '-':
                return reverse ? res + temp : res - temp;
            default:
                return res + temp;
        }
    }

    private int appendNumber(int temp, char c) {
        if (temp == 0) {
            return c - 48;//char 0
        }
        return temp * 10 + c - 48;
    }

    public static void main(String[] args) {
        int res = new Q224().calculate("1");
        System.out.println(res);
    }


}
