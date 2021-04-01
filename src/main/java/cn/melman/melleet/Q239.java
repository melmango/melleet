package cn.melman.melleet;

import java.util.LinkedList;
import java.util.stream.Stream;

public class Q239 {

    //双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {


        if(nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;

    }


    //暴力破解法
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == k) {
            int max = findMax(nums, 0, k);
            return new int[]{max};
        }
        int[] res = new int[nums.length - k + 1];
        int head = nums[0];
        int max = findMax(nums, 0, k);
        res[0] = max;
        for (int i = 1; i < res.length; i++) {
            if (head == max) {
                max = findMax(nums, i, i + k);
            } else {
                int next = nums[i + k-1];
                if (next > max) {
                    max = next;
                }
            }
            head = nums[i];
            res[i] = max;
        }
        return res;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = new Q239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        int[] arr = new Q239().maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
