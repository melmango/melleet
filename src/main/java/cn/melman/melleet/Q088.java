package cn.melman.melleet;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = m;
        if (n >= 0) System.arraycopy(nums2, 0, nums1, start, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 0, 0, 0, 0, 0};
        new Q088().merge(num1, 1, new int[]{1, 2, 3, 4, 5}, 5);
        for (int i : num1) {
            System.out.print(i);
        }


    }
}
