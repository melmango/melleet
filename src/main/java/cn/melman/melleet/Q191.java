package cn.melman.melleet;

/**
 * 2021-3-22
 */
public class Q191 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Q191().hammingWeight(00000000000000000000000000001011) + "");
    }

//    n&n-1会消去最右边的1
//    统计能消多少次即可
//    比如101000&100111 = 100000
//    第一个1右边本来都是0，减1之后，第一个1之后的都变成1了，然后第一个1变成0了，这样与运算，就把随后一个1干没了
//    如果最后结果是0了，说明全是0了

}
