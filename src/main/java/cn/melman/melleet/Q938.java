package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/27 2:52 PM
 */
public class Q938 {

    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        find(root, low, high);
        return res;
    }

    public void find(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val < low) {
            find(node.right, low, high);
        } else if (node.val > high) {
            find(node.left, low, high);
        } else {
            res += node.val;
            find(node.left, low, high);
            find(node.right, low, high);
        }
    }




}
