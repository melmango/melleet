package cn.melman.melleet;

public class Q010 {

    public boolean isMatch(String s, String p) {
        boolean hasStar = p.contains("*");
        int sLen = s.length();
        int pLen = p.length();
        if (!hasStar && sLen != pLen) {
            return false;
        }
        boolean hasPoint = p.contains(".");
        if (!hasPoint && !hasStar) {
            return s.equals(p);
        }
        int pIndex = 0;
        boolean starMagic = false;
        char lastChar = 0;
        for (int i = 0; i < sLen; i++) {
            if (pLen <= i || pLen <= pIndex) {
                return false;
            }
            if (s.charAt(i) == p.charAt(pIndex) || (p.charAt(pIndex) == '.')) {
                pIndex++;
                lastChar = p.charAt(i);
                starMagic = false;
                continue;
            }
            if (p.charAt(pIndex) == '*') {
                starMagic = true;
            }
            if (starMagic && (lastChar == '.' || lastChar == s.charAt(i))) {
                continue;
            }
            pIndex++;
            while (pIndex < pLen) {
                if (p.charAt(pIndex) != '*' && (p.charAt(pIndex) != '.' && p.charAt(pIndex) != s.charAt(i))) {
                    return false;
                }
                if (p.charAt(pIndex) == s.charAt(i)) {
                    lastChar = s.charAt(i);
                    starMagic = false;
                    pIndex++;
                    break;
                }
                pIndex++;
            }
        }
        if (pLen > sLen && pIndex < pLen - 1) {
            boolean startMagic = false;
            char beforeChar = 0;
            for (int start = pIndex; start < pLen; start++) {
                if (beforeChar != 0 && p.charAt(pIndex) != '*') {
                    return false;
                }
                //TODO 不写了！
                
            }
        }
        return true;
    }

    public static void main(String[] args) {


        boolean res = new Q010().isMatch("aaa", "ab*a*c*a");
//        boolean res = new Q010().isMatch("aab", "c*a*b");
//        boolean res = new Q010().isMatch("aab", "c**b*b");
//        boolean res = new Q010().isMatch("mississippi", "mis*is*ip*.");
//        boolean res = new Q010().isMatch("aaa", "ab*a");
        System.out.print(res);
    }
}
