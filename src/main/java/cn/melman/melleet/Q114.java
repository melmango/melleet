package cn.melman.melleet;

import java.util.LinkedList;

public class Q114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        appendNode(list, root.left);
        appendNode(list, root.right);
        TreeNode cursor = root;
        TreeNode treeNode = list.poll();
        while (treeNode != null) {
            cursor.left = null;
            cursor.right = treeNode;
            cursor = cursor.right;
            treeNode = list.poll();
        }
    }

    private void appendNode(LinkedList<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        appendNode(list, node.left);
        appendNode(list, node.right);
    }


}
