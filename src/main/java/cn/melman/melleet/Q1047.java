package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/3/29 10:16 AM
 */
public class Q1047 {


    public String removeDuplicates(String S) {
        int len = S.length();
        if (len < 2) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        char pre = ' ';
        boolean found = false;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == pre) {
                found = true;
                pre = ' ';
                continue;//不要了
            } else {
                if (!found) {
                    if (pre != ' ') {
                        sb.append(pre);
                    }
                    pre = c;
                } else {
                    //如果重复了，清理之前的
                    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                        sb.delete(sb.length() - 1, sb.length());
                        if (sb.length() > 0) {
                            //这里很巧妙，如果是只要重复的就不要，这里就不用判断了即可
                            //但是题目是相邻的两个删除，三个相同的就要留一个，所以这里还要重置标记位，回退
                            //这里还能优化一点点性能，暂不处理了
                            pre = sb.charAt(sb.length() - 1);
                            sb.delete(sb.length() - 1, sb.length());
                            found = false;
                        }
                    } else {
                        found = false;
                        pre = c;
                    }
                }

            }
        }
        if (!found) {
            sb.append(pre);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = new Q1047().removeDuplicates("cmclrhhapqdfkfjllkedgirfpeegjitijeghhqtpaprhnpljcidotmhdrfesieqcjbtrrtbkblboiduqltrbqqfjbmigseoushtardbbhislcnujegkicmlmodqeodoosgguqhnckcjdqdkfnqfqdupuqgpqukeddcalpqtjlhldhndrhpkliposegmeekfokkjsqldehlibposfggitdslltlkhjqtruugkqmqbiuttagmktpkcocfntbrjrpqostkepooqanhbjbemneogtusjnajniudhtritdcrujkagbmofhehldokqprfadsbgdgcflbrnngamdphoptgcqeujfboseescobuoiqrjhbhomnldulduugegoejffsgikbdqorqrjfmiohbmhijpfgkntuersdebapquucmskcblujeqnodaqcaphsuksdfgjlhmnfsgnpupfuarmmtjfimqtksbdchfounolekpdotpspgoukcmrtsnqkdccfjlcmclrhhapqdfkfjllkedgirfpeegjitijeghhqtpaprhnpljcidotmhdrfesieqcjbtrrtbkblboiduqltrbqqfjbmigseoushtardbbhislcnujegkicmlmodqeodoosgguqhnckcjdqdkfnqfqdupuqgpqukeddcalpqtjlhldhndrhpkliposegmeekfokkjsqldehlibposfggitdslltlkhjqtruugkqmqbiuttagmktpkcocfntbrjrpqostkepooqanhbjbemneogtusjnajniudhtritdcrujkagbmofhehldokqprfadsbgdgcflbrnngamdphoptgcqeujfboseescobuoiqrjhbhomnldulduugegoejffsgikbdqorqrjfmiohbmhijpfgkntuersdebapquucmskcblujeqnodaqcaphsuksdfgjlhmnfsgnpupfuarmmtjfimqtksbdchfounolekpdotpspgoukcmrtsnqkdccfjl");
        System.out.println(res);
    }
}
