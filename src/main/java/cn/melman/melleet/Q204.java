package cn.melman.melleet;

import java.util.Arrays;

/**
 * @author Melman
 * @date 2021/4/9 12:38 PM
 */
public class Q204 {

    public int countPrimes_slow(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 1;
        //i+=2是要过滤掉偶数
        for (int i = 3; i < n; i += 2) {
            count += isPrimes(i) ? 1 : 0;
        }
        return count;
    }

    //判断是否是素数
    private boolean isPrimes(int i) {
        int sqrt = (int) Math.sqrt(i);
        //一个素数永远都不可能被偶数整除，所以这里是j+=2
        for (int j = 3; j <= sqrt; j += 2) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }


    public int countPrimes(int n) {
        int j;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                j = 2;
                while (true) {
                    if (i * j >= n) {
                        break;
                    }
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }
        int count = 0;
        for (j = 2; j < n; j++) {
            if (isPrime[j]) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int res = new Q204().countPrimes(10);
        System.out.println(res);
    }

}
