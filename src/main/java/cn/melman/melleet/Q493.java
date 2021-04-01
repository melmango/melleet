package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Melman
 * @date 2021/3/31 3:18 PM
 */
public class Q493 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        res.add(empty);//先加一个都有的空数组
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);//排个序，好干活儿，重复的好搞
        appendSub(nums, 0, res, empty);
        return res;
    }

    private void appendSub(int[] nums, int index, List<List<Integer>> res, List<Integer> pre) {
        if (index == nums.length) {
            return;
        }
        int preNum = nums[index];
        for (int i = index; i < nums.length; i++) {
            if (i > index) {
                if (nums[i] == preNum) {
                    continue;
                }
            }
            preNum = nums[i];
            List<Integer> list = new ArrayList<>();
            list.addAll(pre);
            list.add(nums[i]);
            res.add(list);
            if (pre.size() < nums.length - 1) {
                appendSub(nums, i + 1, res, list);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Q493().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }


}
