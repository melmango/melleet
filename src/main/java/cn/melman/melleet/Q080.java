package cn.melman.melleet;

public class Q080 {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int lastTwo = nums[0] - 1;
        int lastOne = nums[0];
        int res = 1;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] == lastOne) {
                if (lastOne == lastTwo) {//够两个了已经，该移动位置了
                    //啥也不干
                } else {
                    lastTwo = lastOne;
                    nums[res] = nums[i];
                    res++;
                }
            } else {
                lastOne = nums[i];
                nums[res] = lastOne;
                res++;
            }
        }
        return res;
    }

}
