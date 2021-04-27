package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/20 9:41 AM
 */
public class Q028 {

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0) {
            if (needle.length() == 0) {
                return 0;
            } else {
                return -1;
            }
        } else if (needle.length() == 0) {
            return 0;
        }
        int i = 0, index = 0, res = -1;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                if (index == 0) {
                    res = i;
                }
                index++;
                if (index == needle.length()) {
                    return res;
                }
                i++;
            } else {
                if (res >= 0) {
                    i = res + 1;
                    res = -1;
                    index = 0;
                } else {
                    i++;
                }
            }
        }
        if (index < needle.length()) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int res = new Q028().strStr("mississippi", "issip");
//        System.out.println(res);
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
//            if (iterator.next() == 2) {
//                iterator.remove();
//            }
        }
        System.out.println(list);
    }
}
