package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/8 9:19 AM
 */
public class Q153 {

    /**
     * 跟33题和81题差不多，那个是找指定数，这个是找最小
     * 因为做过，必须二分了，循环没意思了
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = (l + r) / 2;
        int min = nums[mid];
        while (l <= r) {
            if (nums[mid] > nums[r]) {
                //如果是中点大的话，往后走，肯定后面有最小的
                l = mid + 1;
            } else {
                //如果是中点大的话，肯定是最小的在前面呢
                r = mid - 1;
            }
            mid = (l + r) / 2;
            min = Math.min(nums[mid], min);
        }
        return min;
    }

    public static void main(String[] args) {
        int res = new Q153().findMin(new int[]{4, 5, 1, 2, 3});
        System.out.println(res);
    }


}
