package cn.melman.melleet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Melman
 * @date 2021/4/13 9:11 AM
 */
public class Q783 {

    /**
     * 又审题错了……计算的是所有点的最小差值
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        appendInOrder(root, queue);
        int first = queue.poll();
        int last = queue.poll();
        int min = last - first;
        while (!queue.isEmpty()) {
            first = queue.poll();
            min = Math.min(min, first - last);
            last = first;
        }
        return min;
    }


    public void appendInOrder(TreeNode node, PriorityQueue<Integer> list) {
        if (node == null) {
            return;
        }
        appendInOrder(node.left, list);
        list.add(node.val);
        appendInOrder(node.right, list);
    }

    //这个是相邻两点的最小差值
    public int minBeside(int min, TreeNode root) {
        if (root == null) {
            return min;
        }
        if (root.left != null) {
            min = Math.min(min, Math.abs(root.val - root.left.val));
            min = minBeside(min, root.left);
        }
        if (root.right != null) {
            min = Math.min(min, Math.abs(root.val - root.right.val));
            min = minBeside(min, root.right);
        }
        return min;
    }

}
