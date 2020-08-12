package cn.melman.melleet;

import java.util.HashSet;
import java.util.Set;

public class Q003 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                int count = set.size();
                if (count > res) {
                    res = count;
                }
                while (true) {
                    char poll = s.charAt(left);
                    left++;
                    set.remove(poll);
                    if (poll == c) {
                        break;
                    }
                }
            }
            set.add(c);
        }
        int count = set.size();
        if (count > res) {
            res = count;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int length = new Q003().lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
