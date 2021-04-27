package cn.melman.melleet;

import apple.laf.JRSUIUtils;

import java.util.Arrays;

/**
 * @author Melman
 * @date 2021/4/25 9:08 AM
 */
public class Q897 {

    TreeNode temp;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(0);
        temp = res;
        centerSeq(root);
        return res.right;
    }

    public void centerSeq(TreeNode node) {
        if (node == null) {
            return;
        }
        centerSeq(node.left);
        temp.right = node;
        node.left = null;
        temp = temp.right;
        centerSeq(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        TreeNode res = new Q897().increasingBST(root);
        TreeNode.printInOrder(res);
    }
}
