package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Melman
 * @date 2021/4/25 11:04 AM
 */
public class Q261 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        //i小于10-k+1，要不数字都不够了，咋凑
        for (int i = 1; i < 11 - k; i++) {
            if (i >= n) {
                continue;
            }
            if (n - i < i) {
                //这句是提高效率的利器！！！因为是递增的
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            calc(list, k - 1, n - i, i + 1);
        }
        return res;
    }

    private void calc(List<Integer> list, int k, int amount, int start) {
        if (amount == 0 && k == 0) {
            res.add(list);
            return;
        }
        for (int i = start; i < 11 - k; i++) {
            if (k == 1) {
                if (amount == i) {
                    List<Integer> l = new ArrayList<>();
                    l.addAll(list);
                    l.add(i);
                    res.add(l);
                }
            } else {
                if (amount > i && amount - i > i) {
                    //这句是提高效率的利器！！！因为是递增的，没必要往下看了
                    List<Integer> l = new ArrayList<>();
                    l.addAll(list);
                    l.add(i);
                    calc(l, k - 1, amount - i, i + 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new Q261().combinationSum3(3, 9);
        System.out.println(res);
    }

}
