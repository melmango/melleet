package cn.melman.melleet;

import java.util.*;

/**
 * @author Melman
 * @date 2021/4/12 8:38 AM
 */
public class Q179 {

    /**
     * 思考 弄一个数组0-9，然后再拼
     * 又审错题啦！我的妈呀，这个应该左右出现的数字，重新排列，但是题目中是不能拆数字的，重写吧
     *
     * @param nums
     * @return
     */
    public String largestNumber_wrong(int[] nums) {
        int[] countArray = new int[10];
        int high, i, j;
        for (i = 0; i < nums.length; i++) {
            high = (int) Math.pow(10, (int) Math.log10(nums[i]));
            while (high >= 1) {
                countArray[nums[i] / high]++;
                nums[i] = nums[i] % high;
                high = high / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = 9; i >= 0; i--) {
            for (j = countArray[i]; j > 0; j--) {
                sb.append(i);
            }
        }
        return sb.toString();
    }


    /**
     * 那这是个排序题
     *
     * @param nums
     * @return
     */
    public String largestNumber_wrong2(int[] nums) {
        List[] countArray = new List[10];
        int index, high, i, j;
        for (i = 0; i < nums.length; i++) {
            high = (int) Math.pow(10, (int) Math.log10(nums[i]));
            index = nums[i] / high;
            if (countArray[index] == null) {
                countArray[index] = new ArrayList();
            }
            countArray[index].add(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (i = 9; i >= 0; i--) {
            List<Integer> arr = countArray[i];
            if (arr != null) {
                if (arr.size() > 1) {
                    //排序
                    PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
                    for (int num : arr) {
                        pq.add(String.valueOf(num));
                    }
                    for (String str : pq) {
                        sb.append(str);
                    }
                } else {
                    sb.append(arr.get(0));
                }
            }
        }
        return sb.toString();
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            // x = 30,y = 3,sx =100,sy = 10,first = 303,second = 330 然后乘以对方的乘数之后加上对方，就对齐了，对齐了之后比大小
            //这里还是相当要数学功底的啊！
            // long first = sy * x + y;
            // long second = sx * y + x;
            // return (int) (-1*first + second);
            return (int) (-sy * x - y + sx * y + x);

        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        String res = new Q179().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(res);
    }
}
