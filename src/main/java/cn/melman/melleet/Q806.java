package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/9 5:47 PM
 */
public class Q806 {

    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int last = 0, current;
        for (int i = 0, len = s.length(); i < len; i++) {
            current = widths[s.charAt(i) - 'a'];
            last = last + current;
            if (last > 100) {
                res[0]++;
                last = current;
            }
        }
        if (last > 0) {
            res[0]++;
            res[1] = last;
        }
        return res;
    }

}
