package cn.melman.melleet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        List<Integer> rootList = new LinkedList<>();
        rootList.add(root.val);
        res.add(rootList);
        //处理叶子
        List<TreeNode> leafs = new LinkedList<>();
        append(leafs, root);
        boolean direction = false;
        while (!leafs.isEmpty()) {
            List<TreeNode> children = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            for (TreeNode leaf : leafs) {
                if (direction) {
                    list.add(leaf.val);
                } else {
                    list.add(0, leaf.val);
                }
                append(children, leaf);
            }
            res.add(list);
            leafs = children;
            direction = !direction;
        }
        return res;
    }

    private void append(List<TreeNode> leafs, TreeNode node) {
        if (node.left != null) {
            leafs.add(node.left);
        }
        if (node.right != null) {
            leafs.add(node.right);
        }
    }

}
