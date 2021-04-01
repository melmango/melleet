package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/3/29 10:50 AM
 */
public class Q303 {

    static class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                sums[i] = sum;
            }
        }

        //精髓在于先算了所有的sum，不用每次都sum了，哇咔咔
        public int sumRange(int left, int right) {
            if (left == 0) {
                return sums[right];
            }
            return sums[right] - sums[left - 1];
        }
    }

    ////精髓，
    public static void main(String[] args) {
        NumArray arr = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        int res = arr.sumRange(2, 5);
        System.out.println(res);

    }

}
