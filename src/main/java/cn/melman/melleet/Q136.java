package cn.melman.melleet;

import java.util.Arrays;
import java.util.HashSet;

public class Q136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res =  res^num;
        }
        return res;
    }


    //慢
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        new Q136().singleNumber(new int[]{17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6});
    }

}
