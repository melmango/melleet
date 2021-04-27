package cn.melman.melleet;

import apple.laf.JRSUIUtils;

import java.util.HashSet;

/**
 * @author Melman
 * @date 2021/4/14 9:10 AM
 */
public class Q208 {

    class Trie {
        Trie[] tries = new Trie[26];
        boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.tries[index] == null) {//找到字母初始化去
                    trie.tries[index] = new Trie();
                }
                trie = trie.tries[index];
            }
            trie.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        public Trie searchPrefix(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.tries[index] == null) {//找到字母初始化去
                    return null;
                }
                trie = trie.tries[index];
            }
            return trie;
        }
    }


}
