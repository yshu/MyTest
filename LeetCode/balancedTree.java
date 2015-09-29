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
    public boolean isBalanced(TreeNode root) {
        if(balancedTree(root) >= 0) return true;
        return false;
    }
    
    private int balancedTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int heightLeft = balancedTree(root.left);
        int heightRight = balancedTree(root.right);

        if(heightLeft != -1 && heightRight != -1 && Math.abs(heightLeft - heightRight) <= 1) {
            return Math.max(heightRight, heightLeft) + 1;
        }

        return -1;
    }
}