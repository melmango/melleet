package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/1 9:03 AM
 */
public class Q1006 {

    public int clumsy(int N) {
        int temp = N;
        int tempRes = 0;
        int i = 1;
        int res = 0;
        while (temp > 0) {
            switch (i % 4) {
                case 1:
                    tempRes = temp;
                    break;
                case 2:
                    tempRes = tempRes * temp;
                    break;
                case 3:
                    tempRes = tempRes / temp;
                    break;
                case 0:
                    if (i == 4) {
                        res = tempRes;
                    } else {
                        res = res - tempRes;
                    }
                    res = res + temp;
                    tempRes = 0;
                    break;
                default:
                    break;
            }
            temp = temp - 1;
            i++;
        }
        if (i <= 4) {
            return tempRes;
        }
        res = res - tempRes;
        return res;
    }

    public static void main(String[] args) {
        int res = new Q1006().clumsy(3);
        System.out.println(res);
    }

}
