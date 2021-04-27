package cn.melman.melleet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Melman
 * @date 2021/4/17 9:01 PM
 */
public class Q220 {

    /*
    用的是红黑树，Java中TreeSet结构就是红黑树，只循环一遍就够了，在数里的，有符合的就true
    floor小于等于的最大值
    ceiling大于的最小值
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = nums[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);//来一个不行就加一个
            if (i >= k) ts.remove(nums[i - k] * 1L);//超过了k，就删一个

        }
        return false;

    }

    //////////////
    long size;

    /**
     *
     * 桶排序，把详尽为t的放在一个桶里，如果index符合，然后在一个桶里，就OK了
     * 每一个差值，就是一个桶，这个是精髓，看在不在一个桶里
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate_tong(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k] * 1L));
        }
        return false;
    }

    long getIdx(long u) {
        return u >= 0 ? u / size : (u + 1) / size - 1;
    }
///////////////////

    public boolean containsNearbyAlmostDuplicate_slow(int[] nums, int k, int t) {
        if (nums.length == 0) {
            if (k == 0 && t == 0) {
                return true;
            }
            return false;
        }
        int i, j, len;
        for (i = 0; i < nums.length; i++) {
            len = i + k + 1;
            if (len > nums.length) {//后面没有了
                len = nums.length;
            }
            for (j = i + 1; j < len; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new Q220().containsNearbyAlmostDuplicate_tong(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
//        boolean res = new Q220().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
//        boolean res = new Q220().containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);
        System.out.println(res);
    }

}
