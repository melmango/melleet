package cn.melman.melleet;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Melman
 * @date 2021/4/19 8:48 AM
 */
public class Q1763 {


    public String longestNiceSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return "";
        }
        String ans = "";
        // len 滑动窗口长度
        for (int len = 2; len <= n; len++) {
            // i 滑动窗口起始位置
            for (int i = 0; i + len - 1 < n; i++) {
                //如果不够长，就不用算了
                if (len < ans.length()) continue;

                String substring = s.substring(i, i + len);
                if (isNicety(substring)) {

                    ans = substring;
                }
            }
        }
        return ans;
    }

    HashSet<Character> upperSet = new HashSet<>();
    HashSet<Character> lowerSet = new HashSet<>();

    private boolean isNicety(String s) {
        upperSet.clear();
        lowerSet.clear();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperSet.add(ch);
            } else {
                lowerSet.add(Character.toUpperCase(ch));
            }
        }
        if (upperSet.size() != lowerSet.size()) {
            return false;
        }
        upperSet.removeAll(lowerSet);
        return upperSet.size() == 0;
    }


    public static void main(String[] args) {
        String res = new Q1763().longestNiceSubstring("YazaAay");
        System.out.println(res);
    }

}
