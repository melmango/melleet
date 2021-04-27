package cn.melman.melleet;

import java.util.Deque;

/**
 * 面试题 17.21. 直方图的水量
 *
 * @author Melman
 * @date 2021/4/2 9:07 AM
 */
public class MS1721 {

    //双指针（左、右），动态移动计算，并标记第二高的，避免反复运算
    public int trap(int[] height) {
        int res = 0;
        int start = 0;

        int left = 0;
        int leftIndex = 0;
        int second = 0;
        int secondIndex = 0;

        while (start < height.length) {
            for (int i = start; i < height.length; i++) {
                if (left == 0) {
                    //左侧没找到呢，直接定一个左侧
                    left = height[i];
                    leftIndex = i + 1;
                } else {
                    //如果左侧找到了，如果右侧的有比左侧大的，结算
                    if (height[i] < left) {
                        if (height[i] > second) {
                            second = height[i];
                            secondIndex = i;
                        }
                        continue;
                    } else {
                        //如果两边相等或者右边大，就转移区间
                        //现在跟左边有空间了
                        while (leftIndex < i) {
                            res = res + left - height[leftIndex];
                            leftIndex++;
                        }
                        left = height[i];
                        leftIndex = i;
                        second = 0;
                        secondIndex = 0;
                        start = i;
                    }
                }
            }
            if (secondIndex > 0) {
                while (leftIndex < secondIndex) {
                    if (height[leftIndex] < second) {
                        res = res + second - height[leftIndex];
                    }
                    leftIndex++;
                }
                left = second;
                leftIndex = secondIndex;
                second = 0;
                secondIndex = 0;
                start = leftIndex + 1;
            } else {
                start++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int res = new MS1721().trap(new int[]{4, 2, 0, 3, 2, 4, 3, 4});
        System.out.println(res);
    }

}
