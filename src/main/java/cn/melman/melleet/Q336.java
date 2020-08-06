package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q336 {

    //时间复杂度O(n2xm)m为字符串的平均长度,空间复杂度O(1)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0, length = words.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                boolean isRoll = isRoll(words[i], words[j]);
                if (isRoll) {
                    temp.add(buildList(i, j));
                }
                boolean isRollBack = isRoll(words[j], words[i]);
                if (isRollBack) {
                    temp.add(buildList(j, i));
                }
            }
        }
        return temp;
    }

    private List<Integer> buildList(int i1, int i2) {
        List res = new ArrayList();
        res.add(i1);
        res.add(i2);
        return res;
    }

    private boolean isRoll(String s1, String s2) {
        String combine = s1 + s2;
        int length = combine.length();
        for (int i = 0; i < length / 2; i++) {
            if (combine.charAt(i) != combine.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Q336().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(new Q336Best().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }
}
