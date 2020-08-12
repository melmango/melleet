package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class Q093 {


    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        append(res, new StringBuilder(), s, 0);
        return res;
    }

    private void append(List<String> list, StringBuilder sb, String s, int found) {
        System.out.printf("%s--%s--%s--%d\n", list.toString(), sb == null ? "null" : sb.toString(), s, found);
        if (found == 3 && s.length() > 3) {
            return;
        }
        if (s.length() < (4 - found)) {
            return;
        }
        if (found == 3) {
            if (s.charAt(0) == '0' && s.length() > 1) {
                return;
            }
            int leftValue = getNumber(s);
            if (leftValue >= 0) {
                list.add(new StringBuilder(sb).append('.').append(leftValue).toString());
            }
        } else {
            if (s.charAt(0) == '0') {
                append(list, new StringBuilder(sb).append(found == 0 ? "" : ".").append(0), s.substring(1), found + 1);
            } else {
                int left = s.length() > 3 ? 3 : s.length();
                for (int i = 1; i <= left; i++) {
                    String str = s.substring(0, i);
                    int value = getNumber(str);
                    if (value >= 0) {
                        append(list, new StringBuilder(sb).append(found == 0 ? "" : ".").append(value), s.substring(i), found + 1);
                    }
                }
            }
        }
    }

    private int getNumber(String str) {
        int value = Integer.valueOf(str);
        return value <= 255 ? value : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q093().restoreIpAddresses("25525511135"));
//        System.out.println(new Q093().restoreIpAddresses("010010"));
    }

}
