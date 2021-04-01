package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        res.add(rootList);
        //处理叶子
        List<TreeNode> leafs = new ArrayList<>();
        append(leafs, root);
        while (!leafs.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (TreeNode leaf : leafs) {
                list.add(leaf.val);
                append(children, leaf);
            }
            res.add(list);
            leafs = children;
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
