package cn.melman.melleet;

public class Q055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int temp;
        boolean res = true;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                res = false;
                temp = i - 1;
                while (temp >= 0) {
                    if (nums[temp] > (i - temp)) {//不是最后一个，得跳过0去，不能正好
                        res = true;
                        if (temp == 0) {
                            return true;
                        }
                        i = temp;//如果能跳过去，就接着往回导
                        break;
                    } else if ((i == len - 1) && nums[temp] == (i - temp)) {//如果是最后一个，可以正好够
                        res = true;
                        if (temp == 0) {
                            return true;
                        }
                        i = temp;//如果能跳过去，就接着往回导
                        break;
                    }
                    temp--;
                }
                if (!res) {
                    return res;
                }
            }
        }
        return res;
    }

    public static final void main(String[] args) {
//        System.out.println(new Q055().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Q055().canJump(new int[]{2, 0, 1, 0, 1}));
//        System.out.println(new Q055().canJump(new int[]{2, 0, 0}));
    }
}
