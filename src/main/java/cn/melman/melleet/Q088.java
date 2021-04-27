

package cn.melman.melleet;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 2021.4.5优化
 */
public class Q088 {

    public void merge_old(int[] nums1, int m, int[] nums2, int n) {
        int start = m;
        if (n >= 0) System.arraycopy(nums2, 0, nums1, start, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
//        int[] num1 = new int[]{ 0};
//        new Q088().merge(num1, 0, new int[]{1 }, 1);
//        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
//        new Q088().merge(num1, 3, new int[]{2, 3, 6}, 3);
        int[] num1 = new int[]{0, 0, 0, 0, 0};
        new Q088().merge(num1, 0, new int[]{1, 2, 3, 4, 5}, 5);
        for (int i : num1) {
            System.out.print(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int index2 = nums2.length - 1;
        int cursor = nums1.length - 1;
        int index1 = m - 1;
        while (index2 >= 0) {
            if (index1 < 0 || nums2[index2] >= nums1[index1]) {
                nums1[cursor] = nums2[index2];
                index2--;
            } else {
                nums1[cursor] = nums1[index1];
                index1--;
            }
            cursor--;
        }
    }


}
