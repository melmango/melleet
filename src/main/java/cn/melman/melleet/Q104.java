package cn.melman.melleet;

/**
 * 二叉树最大深度
 */
public class Q104 {



    public int maxDepth(TreeNode root) {
//        return append(0, root);
//        return append(0, root);
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int append(int count, TreeNode node) {
        if (node == null) {
            return count;
        }
        int resL = count;
        if (node.left != null) {
            resL = append(count + 1, node.left);
        }
        if (node.right != null) {
            return Math.max(resL, append(count + 1, node.right));
        } else {
            return resL;
        }
    }

}
