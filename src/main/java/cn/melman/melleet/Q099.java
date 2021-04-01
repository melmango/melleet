package cn.melman.melleet;

public class Q099 {

    TreeNode change1 = null;
    TreeNode change2 = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        preorder(root);
        int temp = change1.val;
        change1.val = change2.val;
        change2.val = temp;
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preorder(node.left);
        if (pre != null) {
            if (pre.val > node.val) {
                if (change1 != null) {
                    change1 = pre;
                } else {
                    change2 = pre;
                }
            }
        }
        pre = node;
        preorder(node.right);
    }

}
