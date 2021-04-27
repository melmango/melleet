package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/23 9:07 AM
 */
public class Q368 {


    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                //这里是重点啊！！！maxVal得确定出来，不管多小也得可以整除
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }








    List<Integer> finalRes = new ArrayList<>();

    public List<Integer> largestDivisibleSubset_slow(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        findNext(nums, 0, list);
        return finalRes;
    }

    public void findNext(int[] nums, int index, List<Integer> res) {
        int last = res.size() == 0 ? 1 : res.get(res.size() - 1);
        for (int i = index; i < nums.length; i++) {
            if (nums[i] % last == 0) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(res);//分出一只不要的，去接着找
                findNext(nums, i + 1, newList);
                res.add(nums[i]);
                last = nums[i];
            }
        }
        if (finalRes.size() < res.size()) {
            finalRes = res;
        }
    }


    public static void main(String[] args) {
//        List<Integer> res = new Q368().largestDivisibleSubset(new int[]{1, 2, 3});
//        List<Integer> res = new Q368().largestDivisibleSubset(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824});
        List<Integer> res = new Q368().largestDivisibleSubset(new int[]{4,5, 9, 18, 54, 108, 540, 90, 180, 360, 720});
        System.out.println(res);
    }

}
