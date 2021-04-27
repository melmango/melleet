package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/13 3:09 PM
 */
public class Q1705 {

    public int eatenApples(int[] apples, int[] days) {
        int i;
        int res = 0;
        int maxDays = 0;
        for (i = 0; i < days.length; i++) {
            if (i + days[i] > maxDays) {
                maxDays = i + days[i];
            }
        }
        int[] leftArr = new int[maxDays + 1];
        for (i = 0; i < apples.length; i++) {
            if (apples[i] > 0) {
                //如果有苹果
                leftArr[i + days[i] - 1] = leftArr[i + days[i] - 1] + apples[i];
            }
            if (eatOne(i, leftArr)) {
                res++;
            }
        }
        while (eatOne(i, leftArr)) {
            res++;
            i++;
        }
        return res;
    }

    private boolean eatOne(int i, int[] leftArr) {
        for (; i < leftArr.length; i++) {
            if (leftArr[i] > 0) {
                leftArr[i]--;
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int res = new Q1705().eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
//        int res = new Q1705().eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2});
//        int res = new Q1705().eatenApples(new int[]{3, 1, 1, 0, 0, 2}, new int[]{3, 1, 1, 0, 0, 2});
        System.out.println(res);
    }

}
