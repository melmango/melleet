package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Melman
 * @date 2021/3/26 2:42 PM
 */
public class Q341 {

    // This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        //精髓在这里，如果是int，就返回true，如果是个list就返回false，知道最后都是true就循环完了

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();

    }

    public static class NestedIterator implements Iterator<Integer> {

        private List<Integer> vals;
        private Iterator<Integer> cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            vals = new ArrayList<Integer>();
            dfs(nestedList);
            cur = vals.iterator();
        }

        @Override
        public Integer next() {
            return cur.next();
        }

        @Override
        public boolean hasNext() {
            return cur.hasNext();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger integer : nestedList) {
                if (integer.isInteger()) {
                    vals.add(integer.getInteger());
                } else {
                    //用递归实现深度优先，没啥东西，就是没看明白题
                    dfs(integer.getList());
                }
            }
        }


    }


    public static void main(String[] args) {

    }


}
