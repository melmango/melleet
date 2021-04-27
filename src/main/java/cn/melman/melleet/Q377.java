package cn.melman.melleet;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Melman
 * @date 2021/4/24 9:25 PM
 */
public class Q377 {


    /**
     * 动态规划，是要每一次运算都有所记录，建立length+1的新数组，去规划去！
     * 377为综合综合4，123也要练一下！
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    /**
     * 算对了，但速度太慢了，这个就是普通递归的方法，约等于N方的速度
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4_slow(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += calc(nums, target, i);
        }
        return res;
    }

    private int calc(int[] nums, int target, int start) {
        if (target == nums[start]) {
            return 1;
        } else if (target < nums[start]) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += calc(nums, target - nums[start], i);

        }
        return res;
    }

    public static void main(String[] args) {
//        int res = new Q377().combinationSum4(new int[]{1, 2, 3}, 4);
        int res = new Q377().combinationSum4(new int[]{1, 50}, 200);
        System.out.println(res);
    }

}
