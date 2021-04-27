package cn.melman.melleet;

/**
 * @author Melman
 * @date 2021/4/12 10:36 AM
 */
public class Q1367 {

    /**
     * 从572题过来的，思路一样的，套路题。
     * <p>
     * 一路递归左边右边搞定！
     *
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (head == null) return false;
        return isSubPath(head, root.left) || isSame(head, root) || isSubPath(head, root.right);
    }

    public boolean isSame(ListNode head, TreeNode root) {
        if (head == null) return true;//没了，那就对了
        if (root == null) return false;//list还有root没了，那肯定不对，不够啊
        if (head.val != root.val) return false;
        return isSame(head.next, root.left) || isSame(head.next, root.right);
    }

}
