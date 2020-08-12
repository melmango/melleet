package cn.melman.melleet;

import java.util.HashMap;
import java.util.Map;

public class Q001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw null;
    }

    public static void main(String[] args) {
        try {
            int[] ret = new Q001().twoSum(new int[]{3, 3}, 6);
            System.out.printf("return:[%d,%d]", ret[0], ret[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
