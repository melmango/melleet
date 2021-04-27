package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/10 5:40 PM
 */
public class Q263 {

    public boolean isUgly(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        return n <= 1;
    }


}
