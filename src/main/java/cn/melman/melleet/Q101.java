package cn.melman.melleet;

public class Q101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmPair(root.left, root.right);
    }

    private boolean isSymmPair(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else if (q == null) {
            return false;
        }
        if (p.val == q.val) {
            if (isSymmPair(p.left, q.right)) {
                return isSymmPair(p.right, q.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
