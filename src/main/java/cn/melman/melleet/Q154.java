package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/9 9:18 AM
 */
public class Q154 {

    /**
     * 这咋全是这个题啊，33，81，153，都是类似的
     * 测了两次，还真不一样，如果可以重复的，要多判断很多
     * <p>
     * 试了几次二分，还是不行，用循环解决了，第一个比前面小的，就是最小的，如果没有，nums[0]就是最小的
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int res = new Q154().findMin(new int[]{3, 1, 3, 3, 3});
        System.out.println(res);
    }


}
