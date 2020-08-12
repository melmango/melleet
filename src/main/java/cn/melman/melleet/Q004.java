package cn.melman.melleet;

public class Q004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lastOne = 0;
        int lastTwo;
        int total = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while (true) {
            if (index1 == nums1.length) {
                lastTwo = lastOne;
                lastOne = nums2[index2];
                index2++;
                if (index2 == nums2.length) {
                    break;
                }
            } else if (index2 == nums2.length) {
                lastTwo = lastOne;
                lastOne = nums1[index1];
                index1++;
                if (index1 == nums1.length) {
                    break;
                }
            } else if (nums1[index1] < nums2[index2]) {
                lastTwo = lastOne;
                lastOne = nums1[index1];
                index1++;
            } else {
                lastTwo = lastOne;
                lastOne = nums2[index2];
                index2++;
            }
            count++;
            if (count >= (total / 2) + 1) {
                break;
            }
        }
        if (total % 2 == 0) {
            return ((double) (lastOne + lastTwo)) / 2;
        } else {
            return lastOne;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        double res = new Q004().findMedianSortedArrays(arr1, arr2);
        System.out.println(res);
    }
}
