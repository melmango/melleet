package cn.melman.melleet;

public class Q105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        append(root, preorder, inorder, 1, 0, inorder.length);
        return root;
    }

    private void append(TreeNode node, int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        int leftLength = findIndex(node.val, inorder, inStart, inEnd);
        int rightLength = inEnd - inStart - leftLength - 1;
        if (leftLength > 0) {
            TreeNode left = new TreeNode(preorder[preStart]);
            node.left = left;
            if (leftLength > 1) {
                append(node.left, preorder, inorder, preStart + 1, inStart, inStart + leftLength);
            }
        }
        if (rightLength > 0) {
            TreeNode right = new TreeNode(preorder[preStart + leftLength]);
            node.right = right;
            if (rightLength > 1) {
                append(node.right, preorder, inorder, preStart + leftLength + 1, inStart + leftLength + 1, inEnd);
            }
        }
    }

    private int findIndex(int val, int[] inorder, int start, int end) {
        for (int i = 0; i < end - start; i++) {
            if (inorder[i + start] == val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);
//        node.printPreOrder();
//        node.printInOrder();
//        node.printPostOrder();
//        TreeNode node = new Q105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode node = new Q105().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        node.printPreOrder();
        TreeNode.printInOrder(node);
    }

}
