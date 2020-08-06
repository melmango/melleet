package cn.melman.melleet;

import java.util.HashMap;
import java.util.Map;

public class Q001 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) throws Exception {
        for (int i = 0, length = nums.length; i < length; i++) {
            map.put(nums[i], i);
            int find = target - nums[i];
            int index = map.getOrDefault(find, -1);
            if (index >= 0 && i != index) {
                return new int[]{i, index};
            }
        }
        throw new Exception("not found");
    }

    public static void main(String[] args) {
        try {
            int[] ret = new Q001().twoSum(new int[]{2, 7, 11, 15}, 9);
            System.out.printf("return:[%d,%d]", ret[0], ret[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
