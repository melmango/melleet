package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/23 11:26 AM
 */
public class Offer28 {


    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        } else {
            return false;
        }
    }


}
