package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/18 3:38 PM
 */
public class Q026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (last != nums[i]) {
                res++;
                last = nums[i];
            }
        }
        return res;
    }

}
