package cn.melman.melleet;

import java.util.stream.Stream;

public class Q115 {
// 动态规划太好玩儿了，直接右下角就是结果。先来一行1和右边一列0，然后如果发现了，就行+列，如果没发现就行里前一个
//          b g g a b g b a g
//        1 1 1 1 1 1 1 1 1 1
//        0 1 1 1 1 2 2 3 3 3
//        0 0 0 0 1 1 1 1 4 4
//        0 0 0 0 0 0 1 1 1 5
//        res:5

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }


        System.out.print("  ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();
        for (int[] arr : dp) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        return dp[t.length()][s.length()];
    }

    //结果对，但是太慢了
    public double numDistinct2(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return 0;
        }
        int res = 0;
        int lenS = s.length();
        int lenT = t.length();
        char c0 = t.charAt(0);
        for (int i = 0, len = lenS - lenT + 1; i < len; i++) {
            if (s.charAt(i) == c0) {
                if (lenT == 1) {
                    res = res + 1;
                } else {
                    res = res + append(s, t, i + 1, 1, lenS, lenT);
                }
            }
        }
        return res;
    }

    private int append(String s, String t, int indexS, int indexT, int lenS, int lenT) {
        int len = lenS - indexS - lenT + 1 + indexT;
        int res = 0;
        char charT = t.charAt(indexT);
        for (int i = 0; i < len; i++) {
            if (s.charAt(indexS + i) == charT) {
                if (indexT == lenT - 1) {
                    res = res + 1;
                } else {
                    res = res + append(s, t, indexS + i + 1, indexT + 1, lenS, lenT);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int res = new Q115().numDistinct("b", "System.out.print(b");
        int res = new Q115().numDistinct("bggabgbag", "bag");
//        int res = new Q115().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc");
        System.out.println(res);
    }
}
