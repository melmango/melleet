package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/7 9:41 AM
 */
public class Q033 {

    /**
     * 从每日一题的081题过来的，二分法，
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[r]) {
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }
        return -1;
    }

}
