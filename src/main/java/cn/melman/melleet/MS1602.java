package cn.melman.melleet;

import java.util.HashMap;

/**
 * @author Melman
 * @date 2021/4/14 9:39 AM
 */
public class MS1602 {


    class WordsFrequency {
        HashMap<String, Integer> hash = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String s : book) {
                hash.put(s, hash.getOrDefault(s, 0) + 1);
            }
        }

        public int get(String word) {
            Integer res = hash.get(word);
            return res == null ? 0 : res;
        }
    }
}
