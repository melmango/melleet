package cn.melman.melleet;

import java.util.Arrays;

public class Q128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 1;
        int temp = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if ((nums[i] - nums[i - 1]) == 1) {
                temp++;
            } else if (temp > 1) {
                if ((nums[i] - nums[i - 1]) == 0) {
                    continue;
                } else {
                    res = Math.max(temp, res);
                    temp = 1;
                }
            }
        }
        if (temp > 1 && temp > res) {
            return temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q128().longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3}));
    }
}
