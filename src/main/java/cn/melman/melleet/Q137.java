package cn.melman.melleet;

import java.util.HashSet;

public class Q137 {

    //TODO 大神写法，看不懂，卡卡位运算，其他的set和hashmap算法都好说
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    //慢
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            if(set.contains(num)) {
                res = num ^ res;
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        for (Integer integer : set) {
            res  = integer  ^res;
        }
        return res;
    }

}
