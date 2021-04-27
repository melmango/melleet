package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/19 8:41 AM
 */
public class Q027 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }


}
