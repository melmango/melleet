package cn.melman.melleet;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Melman
 * @date 2021/4/11 4:09 PM
 */
public class Q264 {

    /**
     * 之前一直看错题了，原来是要第n个是多少……
     * 那弄n次，算出最小的数，就可以了，用是哪个指针，谁最小用谁，然后一直算下去
     * <p>
     * 最好的办法还是堆，但是没看懂啊！
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = 2 * arr[p2], num3 = 3 * arr[p3], num5 = 5 * arr[p5];
            arr[i] = Math.min(Math.min(num2, num3), num5);
            if (arr[i] == num2) {
                p2++;
            }
            if (arr[i] == num3) {
                p3++;
            }
            if (arr[i] == num5) {
                p5++;
            }
            //这里不能else，相等的也加上去
        }
        return arr[n];
    }

    //TODO 这个堆，太好了，太牛了！
    public int nthUglyNumber_heap(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();//取最上面的，乘以2，3，5去，重复n次，最上面的就是最小的了，这也太巧妙了
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {//如果已经有了，返回false，如果是新的，加入到最小堆里
                    heap.offer(next);
                }
            }
        }
        return ugly;

    }


    public static void main(String[] args) {
        int res = new Q264().nthUglyNumber(12);
        System.out.println(res);
    }


}
