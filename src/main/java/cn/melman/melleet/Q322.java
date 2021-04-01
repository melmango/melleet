package cn.melman.melleet;

import java.util.Arrays;

public class Q322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        Arrays.sort(coins);
        return find(coins, amount, coins.length - 1, 0, -1);
    }

    private int find(int[] coins, int amount, int firstIndex, int sum, int max) {
        System.out.println(amount + "-" + firstIndex + "-" + sum + ":" + max);
        for (int i = firstIndex; i >= 0; i--) {
            if (i > 0) {
                int add = amount / coins[i];
                if (max > 0 && max < add) {//如果已经找到了，然后比现在临时的还小，就直接返回了
                    continue;
                }
                int tempSum = find(coins, amount % coins[i], i - 1, sum + add, max);
                if (tempSum > 0 && (max == -1 || tempSum < max)) {
                    return max;
                } else {
                    return find(coins, amount, i - 1, 0, max);
                }
            } else {
                if (coins[0] > amount || coins[0] % amount != 0) {
                    return -1;
                } else {
                    int add = amount / coins[i];
                    if (max == -1 || sum + add < max) {
                        return sum + add;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int res = new Q322().coinChange(new int[]{186, 419, 83, 408}, 6249);
        System.out.println(res);
    }

}
