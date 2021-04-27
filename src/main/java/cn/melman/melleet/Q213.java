package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/15 9:54 AM
 */
public class Q213 {


    /**
     * 偷懒了，照着198题抄的，不能首位相连，就是算一遍要nums[0]和和不要nums[0]的就行了
     * <p>
     * 如果第一次没用first，就不用再转一圈了，但是多了一个true/false，内存还高了……
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
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        //其实就是只判断了1+3>2，但是步长是1，每一个1+3>2或者2>1+3,都可以确定1个，就O(n)了
        for (int i = 2; i < length - 1; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);//就是偷和不透
            if (i == 2 && second > nums[1]) {
                nums[0] = -1;
            }
            first = temp;
        }
        if (nums[0] == -1) {
            return second;
        }
        int res = second;
        first = nums[1];
        second = Math.max(nums[1], nums[2]);
        for (int i = 3; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);//就是偷和不透
            first = temp;
        }
        return second > res ? second : res;
    }

    public static void main(String[] args) {
        int res = new Q213().rob(new int[]{1, 2, 1, 1});
        System.out.println(res);
    }

}
