package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/9 2:09 PM
 */
public class Q1432 {

    public int maxDiff(int num) {
        if (num < 10) {
            return 8;
        }
        int high = (int) Math.log10(num);
        int divide,s;
        int left = num;
        int max = num, min = num;
        int maxChange = 10, minChange = 0;
        int minChoice = 1;
        while (high >= 0) {
            divide = (int) Math.pow(10, high);
            s = left / divide;
            if (maxChange > 9) {
                //如果还没找到呢
                if (s < 9) {
                    max = num + (9 - s) * divide;
                    maxChange = s;
                }
            } else if (maxChange == s) {
                max = max + (9 - s) * divide;
            }
            if (minChange == 0) {
                //如果还没找到呢
                if (s > 1) {
                    //后面也不能小于1，如果第一位是1后面都不能只1，如果第一位不是1，那第一位改成1就可以了
                    min = num - (s - minChoice) * divide;
                    minChange = s;
                } else {
                    //如果不是第一位了，最小值是0，如果是第一位，最小是1
                    minChoice = 0;
                }
            } else if (minChange == s) {
                //如果找到了，而且这个就是
                min = min - (s - minChoice) * divide;
            }
            left = left - s * divide;
            high--;//一位一位的搞啊
        }
        return max - min;
    }


    public static void main(String[] args) {
        int res = new Q1432().maxDiff(9089733);
        System.out.println(res);

    }
}
