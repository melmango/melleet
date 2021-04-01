package cn.melman.melleet;

public class Q100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else if (q == null) {
            return false;
        }
        if (p.val == q.val) {
            if (isSameTree(p.left, q.left)) {
                return isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
