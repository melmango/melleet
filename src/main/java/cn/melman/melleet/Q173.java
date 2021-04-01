package cn.melman.melleet;

import apple.laf.JRSUIUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Melman
 * @date 2021/3/28 10:38 AM
 */
public class Q173 {

    class BSTIterator {

        Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            init(root);
        }

        private void init(TreeNode node) {
            List<Integer> nodes = new LinkedList<>();
            appendInOrder(node, nodes);
            iterator = nodes.iterator();
        }

        public void appendInOrder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            appendInOrder(node.left, list);
            list.add(node.val);
            appendInOrder(node.right, list);
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

}
