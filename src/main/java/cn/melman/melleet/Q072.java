package cn.melman.melleet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q072 {

    public int minDistance(String word1, String word2) {
        HashMap<Character, LinkedList<Integer>> hash = new HashMap<>();
        int res = 0;
        int removed = 0;
        for (int i = 0, len = word1.length(); i < len; i++) {
            char c = word1.charAt(i);
            LinkedList<Integer> pos = hash.get(c);
            if (pos == null) {
                pos = new LinkedList<>();
                hash.put(c, pos);
            }
            pos.add(i);
        }
        for (int i = 0, len = word2.length(); i < len; i++) {
            char c = word2.charAt(i);
            LinkedList<Integer> pos = hash.get(c);
            if (pos == null) {//如果是空的话，加一个
                res++;
            } else {
                Integer p = pos.poll();
                if (p.intValue() == i) {
                    res++;
                }
                if (pos.isEmpty()) {
                    hash.remove(c);
                }
            }
        }
        for (Map.Entry<Character, LinkedList<Integer>> entry : hash.entrySet()) {
            res = res + entry.getValue().size();
        }
        return res;
    }
}
