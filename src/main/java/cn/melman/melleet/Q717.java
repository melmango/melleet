package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/9 11:41 AM
 */
public class Q717 {

    /**
     * 谈心算法试试，所有1都尽量自己过
     * 上一句相反了，是如果是1的话，后面都要跟着一个，那就简单了
     *
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        int i = 0;
        boolean res = true;
        while (i < len) {
            //如果是1的话，后面直接跟一个
            if (bits[i] == 1) {
                res = false;//这里不行，再有的话才是true
                i++;
            } else {
                res = true;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
//        boolean res = new Q717().isOneBitCharacter(new int[]{1, 1, 1, 0});
        boolean res = new Q717().isOneBitCharacter(new int[]{1, 0, 0});
        System.out.println(res);
    }

}
