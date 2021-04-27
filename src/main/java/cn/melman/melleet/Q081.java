package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/7 9:22 AM
 */
public class Q081 {

    /**
     * 二分的解法，见Q033
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        boolean foundMin = false;
        boolean smaller = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
            if (foundMin) {
                if (nums[i] > target) {
                    //越来越大，如果找到比数大的了，就拉倒了
                    return false;
                }
            } else {
                //还没找到呢
                if (nums[i] < target) {
                    smaller = true;
                } else {
                    if (smaller) {
                        //如果找到小的了，也找到大的了，那肯定没有了，因为是按顺序排的
                        return false;
                    }
                }
            }
            if (i > 0) {
                foundMin = nums[i] < nums[i - 1];
            }
        }
        return false;
    }

}
