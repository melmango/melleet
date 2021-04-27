package cn.melman.melleet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melman
 * @date 2021/4/5 1:54 PM
 */
public class Q781 {


    /**
     * 解题思路：如果数量不同，则一定是不同色的。
     * 如果是最少数量，则同数量的，一定是同色的（这句话不知道对不对）
     *
     * @param answers
     * @return
     */
    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }
        //猜测是第一的，加 1，加上第二的就能覆盖了
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            hash.put(answers[i], hash.getOrDefault(answers[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int num = entry.getValue();
            int diff = entry.getKey();
            if (entry.getValue() <= entry.getKey() + 1) {
                //如果数量少于喊的数量，则数量为喊的数+1，喊的多就是喊的+1
                res = res + entry.getKey() + 1;
            } else {
                //如果兔子喊出来的数量，大于兔子的数量，就不是一个颜色了，那么就再加！
                //100只兔子喊2，那就是三个三个一对儿，33个3，
                //相同数量有多少组
                res = res + (entry.getValue() / (entry.getKey() + 1)) * (entry.getKey() + 1);
                int left = (entry.getValue() % (entry.getKey() + 1));
                if (left > 0) {
                    res = res + entry.getKey() + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int res = new Q781().numRabbits(new int[]{1, 1, 2, 2, 3, 3, 5});
//        int res = new Q781().numRabbits(new int[]{1, 0, 1, 0, 0});//2+1-1+3
//        int res = new Q781().numRabbits(new int[]{2, 0, 2, 0, 0});//2+1+3
//        int res = new Q781().numRabbits(new int[]{2, 2, 2, 0, 0});//3+1-1+2
//        int res = new Q781().numRabbits(new int[]{1, 1, 1, 0, 0});//3+1+2 = 6
        int res = new Q781().numRabbits(new int[]{10, 10, 10});
//        int res = new Q781().numRabbits(new int[]{1, 1, 2});

        System.out.println(res);
    }
}
