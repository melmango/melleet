package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/3/29 10:04 AM
 */
public class Q190 {

    /**
     * 虽然标着是简单，但是完全没思路，太重要了这个题，弱项
     *
     * @param n
     * @return
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            //按32位，一位一位的折腾
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

}
