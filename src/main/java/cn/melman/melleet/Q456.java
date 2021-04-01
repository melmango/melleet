package cn.melman.melleet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Melman
 * @date 2021/3/26 1:36 PM
 */
public class Q456 {


    /**
     * 官方最快的解法，O(n)，从右到左一个栈，压就完事儿了！
     * @param nums
     * @return
     */
    public boolean find132pattern_official(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }


    //慢到不让提交了，n立方
    public boolean find132pattern_old(int[] nums) {
        if (nums == null || nums.length < 3) {
            //数量不够就没戏
            return false;
        }
        int i = 0, j, k, len = nums.length;
        for (; i < len - 2; i++) {
            for (j = i + 1; j < len - 1; j++) {
                if (nums[i] < nums[j]) {
                    for (k = j + 1; k < len; k++) {
                        if (nums[k] > nums[i] && nums[k] < nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    /**
     * 思考过程：
     * num[i]最小，nun[j]最大，只要找到大于i的
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;//数量不够就没戏
        }
        int i = 0, j = 1, k = 2, temp, len = nums.length;
        boolean movingK = false;//K是游标，当左边满足的时候，溜达k
        while (true) {
            if (movingK) {//如果i和j满足条件了
                if (nums[k] >= nums[j]) {//如果k大了，移动j，保证nums[j]是已知最大的
                    for (temp = j; temp < k; temp++) {
                        if (nums[temp] < nums[i]) {
                            i = temp;
                        }
                    }
                    j = k;
                    k++;
                    if (k == len) {
                        break;
                    }
                } else {
                    if (nums[k] > nums[i]) {
                        return true;
                    } else {//k小于j也小于等于i
                        k++;
                        if (k == len) {//不行了，没有了，还得溜达i和j
                            System.out.println("K到头了");
                            if (i >= len - 2) {
                                break;
                            }
                            i++;
                            j = i + 1;
                            k = j + 1;
                            movingK = false;
                        }
                    }
                }
            } else {
                if (nums[i] < nums[j]) {//如果j小于i
                    if (j == len - 1) {
                        break;
                    }
                    k = j + 1;
                    movingK = true;
                } else {
                    i = j;//这样能保证num[i]是一直的最小的
                    j++;
                    if (j == len) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new Q456().find132pattern(new int[]{40, 50, 25, 35, 15, 35, 20});
        System.out.println(res);
    }
}
