package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/9 11:58 AM
 */
public class Q650 {

//    static int[] payload = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23};

    public int minSteps(int n) {
        int minZhi = 2;
        int count = 0;
//        List<Integer> zhiList = new ArrayList<>();
        while (true) {
            if (n % minZhi == 0) {
                //核心在这里！！！每次用最小的质数取余，然后操作质数次，就是最小成绩
                count = count + minZhi;//复制1次然后粘贴N-1次
                n = n / minZhi;
            } else {
//                minZhi = findNextZhi(minZhi, zhiList);//这里是不是要优化一下
                minZhi = findNextZhi(minZhi);//这里是不是要优化一下
//                zhiList.add(minZhi);
            }
            if (n == 1) {
                break;
            }
        }
        return count;
    }

    //计算大于X的最小质数
    public int findNextZhi(int start) {
        int temp = start;
        int i;
        while (true) {
            temp++;
            for (i = temp; i >= 2; i--) {
                if (temp % i == 0) {
                    break;
                }
            }
            return temp;
        }
    }


    public int findNextZhi(int start, List<Integer> list) {
        int temp = start;
        while (true) {
            temp++;
            for (Integer i : list) {
                if (temp % i == 0) {
                    break;
                }
            }
            return temp;
        }
    }


    public static void main(String[] args) {
        int res = new Q650().minSteps(23);
        System.out.println(res);
    }

}
