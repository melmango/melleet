package cn.melman.melleet;

public class Q053 {
    //最佳
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        //如果之前还没有现在这个数大呢，那就只要现在这个数，我的天啊！！！
        return maxAns;
    }

    //内存小速度慢
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int r;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            max = Math.max(temp, max);
            r = i + 1;
            while (r < len) {
                temp = temp + nums[r];
                max = Math.max(temp, max);
                r++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Q053().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
