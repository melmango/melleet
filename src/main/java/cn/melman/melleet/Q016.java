package cn.melman.melleet;

import java.util.Arrays;

public class Q016 {

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);
        Arrays.sort(nums);
        int len = nums.length;
        int L, R;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                int newDiff = Math.abs(sum - target);
                if (newDiff <= diff) {
                    res = sum;
                    diff = newDiff;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    k--;
                    // 移动到下一个不相等的元素
                    while (j < k && nums[k + 1] == nums[k]) {
                        k--;
                    }
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    j++;
                    // 移动到下一个不相等的元素
                    while (j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q016().threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}
