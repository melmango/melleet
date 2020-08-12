package cn.melman.melleet;

public class Q014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean found = true;
        char lastChar;
        while (found) {
            lastChar = '0';
            for (int i = 0; i < strs.length; i++) {
                if (i == 0 && strs[i].length() == 0) {
                    return "";
                }
                if (strs[i].length() <= index) {
                    found = false;
                    break;
                }
                if (lastChar == '0') {
                    lastChar = strs[i].charAt(index);
                } else {
                    if (lastChar != strs[i].charAt(index)) {
                        found = false;
                        break;
                    }
                }
            }
            if (found) {
                sb.append(strs[0].charAt(index));
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q014().longestCommonPrefix(new String[]{"a"}));
    }
}
