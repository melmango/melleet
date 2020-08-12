package cn.melman.melleet;

import java.util.stream.Stream;

public class Q011 {


    public int maxArea(int[] height) {
        //模仿的单指针
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(temp, res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    //慢
    public int maxArea1(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                res = Math.max(temp, res);
            }
        }
        return res;
    }
}
