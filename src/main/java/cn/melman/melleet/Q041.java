package cn.melman.melleet;

import java.util.Arrays;

public class Q041 {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        if (nums.length == 1 && nums[0] != 1) return 1;
        Arrays.sort(nums);
        int missing = 1;
        for (int i = 0; i < nums.length; i++) {
            if (missing == nums[i]) {
                missing++;
            }
            if (missing < nums[i]) {
                break;
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        int res = new Q041().firstMissingPositive(new int[]{186, 419, 83, 408});
        System.out.println(res);
    }
}
