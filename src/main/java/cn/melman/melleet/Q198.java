package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/15 9:23 AM
 */
public class Q198 {
    /**
     * 从每日任务213过来的，说是简单版，213就是首尾不能连着偷
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        //其实就是只判断了1+3>2，但是步长是1，每一个1+3>2或者2>1+3,都可以确定1个，就O(n)了
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);//就是偷和不透
            first = temp;
        }
        return second;
    }

    /**
     * 第一次解题，纯动态规划，没有优化，太慢了
     *
     * @param nums
     * @return
     */
    public int rob_show(int[] nums) {
        return append(0, nums, 0);
    }

    public int append(int res, int[] nums, int start) {
        if (start >= nums.length) {
            return res;
        }
        int res1 = append(res + nums[start], nums, start + 2);//如果这个偷了，就跳两个去判断
        int res2 = append(res, nums, start + 1);//这个不要了，继续去加另一个
        return Math.max(res1, res2);
    }


    public static void main(String[] args) {
        int res = new Q198().rob(new int[]{2, 7, 9, 3, 1});
//        int res = new Q198().rob(new int[]{1, 2, 3, 1});
//        int res = new Q198().rob(new int[]{2,1,1,2});
        System.out.println(res);
    }
}
