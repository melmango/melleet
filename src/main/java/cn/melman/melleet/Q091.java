package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/21 9:01 AM
 */
public class Q091 {


    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                //如果自己不是0的话，相当于继续往前走，前面是几种可能，就集中可能
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                //如果自己被拆，那就多了一种可能，那就是前面的加上自己的
                //这一步还是很难理解的
                f[i] += f[i - 2];
                //下面是过程数据，就是如果自己可以跟上一个凑的时候，可能性就是自己加上上一个的。
//                [1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//                [1, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//                [1, 1, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0]
//                [1, 1, 2, 3, 5, 8, 0, 0, 0, 0, 0, 0, 0]
//                [1, 1, 2, 3, 5, 8, 13, 0, 0, 0, 0, 0, 0]
//                [1, 1, 2, 3, 5, 8, 13, 21, 0, 0, 0, 0, 0]
//                [1, 1, 2, 3, 5, 8, 13, 21, 34, 0, 0, 0, 0]
//                [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 0, 0, 0]
//                [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 0, 0]
//                [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 0]
//                [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233]
//                System.out.println(Arrays.toString(f));
            }
        }
        return f[n];
    }


    int res;

    /**
     * 基本思路没问题，但是在11111111111111的时候，太慢了，要循环太多次了！
     *
     * @param s
     */
    public int numDecodings_slow(String s) {
        if (s.equals("0")) {
            return 0;
        }
        res = 0;
        findNum(s, 0);
        return res;
    }

    private void findNum(String s, int start) {
        int i;
        for (i = start; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                return;
            } else if (c == '1') {
                if (s.charAt(i + 1) == '0') {
                    findNum(s, i + 2);
                    return;
                } else {
                    findNum(s, i + 2);
                }
            } else if (c == '2') {
                if (s.charAt(i + 1) == '0') {
                    //如果是0的话，就只能跟了
                    findNum(s, i + 2);
                } else if (s.charAt(i + 1) < '7') {
                    //可以两个
                    findNum(s, i + 2);
                } else {
                    //如果2之后大于6了，继续看吧
                }
            } else {
                if (s.charAt(i + 1) == '0') {
                    //如果是3开头的，就只能自己了，直接找下一个去
                    return;
                } else {
                }
            }
        }
        res++;
    }

    public static void main(String[] args) {
//        int res = new Q091().numDecodings("99");
//        int res = new Q091().numDecodings("111111111111111111111111111111111111111111111");
        int res = new Q091().numDecodings("222222222222");
        System.out.println(res);
//        1836311903
    }

}
