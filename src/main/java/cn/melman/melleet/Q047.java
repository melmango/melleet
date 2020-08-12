package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 全排列
 */
public class Q047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        ArrayList<Integer> total = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            total.add(nums[i]);
        }
        trackBack(total, res, null);
        return res;
    }

    private void trackBack(List<Integer> left, List<List<Integer>> res, List<Integer> temp) {
        int lastNum = left.get(0);
        for (int i = 0, len = left.size(); i < len; i++) {
            List<Integer> list = new ArrayList<>(len);
            if (temp != null) {
                list.addAll(temp);
            }
            int num = left.get(i);
            if (i != 0 && lastNum == num) {
                continue;
            }
            lastNum = num;
            list.add(left.get(i));
            if (left.size() == 1) {
                res.add(list);
            } else {
                List<Integer> newLeft = new ArrayList<>();
                newLeft.addAll(left);
                newLeft.remove(i);
                trackBack(newLeft, res, list);
            }
        }
    }


}
