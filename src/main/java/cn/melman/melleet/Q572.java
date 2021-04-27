package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/12 9:31 AM
 */
public class Q572 {

    /**
     * 思考：最简单的就是如果s遍历的时候，发现与t的根节点相同的节点，就轮一下子树
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (t == null) return false;
        return isSubtree(s.left, t) || isSameTree(s, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
