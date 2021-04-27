package cn.melman.melleet;

import java.util.Arrays;

/**
 * @author Melman
 * @date 2021/4/26 8:59 AM
 */
public class Q1011 {


    /**
     *这个是最优解，还是挺厉害的，用了max和sum进行二分，毕竟是二分吧，还是快不少啊
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public int shipWithinDays_mySlow(int[] weights, int D) {
        int i, max = 0, temp = 0, days = 0;
        for (i = 0; i < weights.length; i++) {
            temp += weights[i];
            if (weights[i] > max) {
                max = weights[i];
            }
        }
        if (temp / D > max) {
            max = temp / D;
        }
        while (true) {
            temp = max;
            days = 1;
            for (i = 0; i < weights.length; i++) {
                temp = temp - weights[i];
                if (temp < 0) {
                    days++;
                    if (days > D) {
                        break;
                    }
                    temp = max - weights[i];
                }
            }
            if (days <= D) {
                return max;
            }
            max++;
        }
    }


    public static void main(String[] args) {
        int res = new Q1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.println(res);
    }
}
