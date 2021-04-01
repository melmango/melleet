package cn.melman.melleet;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void printPreOrder() {
        List<Integer> list = new ArrayList<>();
        appendPreOrder(this, list);
        System.out.println("pre = " + list);
    }

    public static void appendPreOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        appendPreOrder(node.left, list);
        appendPreOrder(node.right, list);
    }

    public static void printInOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        appendInOrder(node, list);
        System.out.println("in = " + list);

    }

    public static void appendInOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        appendInOrder(node.left, list);
        list.add(node.val);
        appendInOrder(node.right, list);
    }


    public void printPostOrder() {
        List<Integer> list = new ArrayList<>();
        appendPostOrder(this, list);
        System.out.println("post = " + list);
    }

    private void appendPostOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        appendPostOrder(node.left, list);
        appendPostOrder(node.right, list);
        list.add(node.val);
    }

}