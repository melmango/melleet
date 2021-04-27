package cn.melman.melleet;

import java.util.*;

/**
 * @author Melman
 * @date 2021/4/15 10:30 AM
 */
public class MS1722 {

    // 粘锅来的广度优先算法，会快一点
    // 构造后继图，每个单词的后继列表
    public void buildNextWordsMap(HashMap<String, List<String>> nextWordsMap, Set<String> wordSet) {
        char[] wordArr;
        for (String word : wordSet) {
            wordArr = word.toCharArray();
            List<String> nextWords = new ArrayList<>();
            //对于每个单词，每次变换一位，然后查看worSet中是否含有，有的话就是后继。
            for (int i = 0; i < wordArr.length; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordArr[i] != j) {
                        char temp = wordArr[i];
                        wordArr[i] = j;
                        String tempWord = String.valueOf(wordArr);
                        if (wordSet.contains(tempWord)) {
                            nextWords.add(tempWord);
                        }
                        //还原
                        wordArr[i] = temp;
                    }
                }
            }
            nextWordsMap.put(word, nextWords);
        }
    }

    //执行广度优先搜索
    public List<String> BFS(HashMap<String, List<String>> nextWordsMap, String beginWord, String endWord) {
        //保存结果
        List<String> changePaths = new LinkedList<>();
        //保存搜索路径，key表示当前节点，value是当前节点的前驱节点，最后从endWord反向索引至beginWord即得到最短的变换路径
        HashMap<String, String> findPathMap = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        queue.offer(beginWord);
        isVisited.add(beginWord);
        outer:
        while (!queue.isEmpty()) {
            String word = queue.poll();
            //遍历后继
            for (String nextWord : nextWordsMap.get(word)) {
                if (!isVisited.contains(nextWord)) {
                    queue.add(nextWord);
                    findPathMap.put(nextWord, word);
                    isVisited.add(nextWord);
                    if (nextWord.equals(endWord)) {
                        break outer;
                    }
                }
            }
        }
        //反向遍历得到索引路径，因为每个节点只有一个前驱，如果起点到终点有路径就可以到达。
        String cur = endWord;
        changePaths.add(cur);
        String pre;
        do {
            pre = findPathMap.get(cur);
            if (pre == null) {
                return new ArrayList<>();
            }
            changePaths.add(pre);
            cur = pre;
        } while (!cur.equals(beginWord));
        //反转
        Collections.reverse(changePaths);
        return changePaths;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 保存单词集
        Set<String> wordSet = new HashSet<>();
        wordSet.add(beginWord);
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        // 保存后继图
        HashMap<String, List<String>> nextWordsMap = new HashMap<>();
        buildNextWordsMap(nextWordsMap, wordSet);
        //执行广度优先遍历
        return BFS(nextWordsMap, beginWord, endWord);
    }










    ////////////


    private List<String> path = new ArrayList<>();
    private Set<String> history = new HashSet<>();

    /**
     * 太费劲了，粘过来的答案
     * 深度优先，有点儿慢啊
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<String> findLadders_show(String beginWord, String endWord, List<String> wordList) {
        if (finish(beginWord, endWord, wordList)) {
            path.add(0, beginWord);
        }
        return path;
    }

    boolean finish(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return true;
        }//如果相等就是找到了
        if (!wordList.contains(endWord) || history.contains(beginWord)) {
            return false;
        }
        Iterator<String> iterator = wordList.iterator();
        int i = wordList.size() - 1;
        while (iterator.hasNext() && i >= 0) {
            String cur = wordList.get(i);
            if (near(beginWord, cur)) {
                wordList.remove(i);
                path.add(cur);
                //开始动态规划了这里，但是没办法啊，每个单词开头都要试一下，慢就慢吧，要不路径过不去更麻烦，没有想出最短路径的算法，这里明显是深度优先算法的
                if (finish(cur, endWord, wordList)) {
                    return true;
                }
                //如果没有return走，那就从list里面摘出去，然后继续下一个
                history.add(cur);//这里主要是不行的排重
                path.remove(path.size() - 1);
                wordList.add(cur);
            }
            i--;
        }
        return false;
    }

    //找diff为1的也就是只查一个字符的单词
    boolean near(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length() && diff <= 1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
