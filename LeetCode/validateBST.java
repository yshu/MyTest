/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTSub(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }

    boolean isValidBSTSub(TreeNode root, long min, long max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return isValidBSTSub(root.left, min, root.val) && isValidBSTSub(root.right, root.val, max);
    }
}