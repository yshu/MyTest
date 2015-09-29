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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            if(current == null) {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
            else {
                stack.push(current);
                current = current.left;
            }
        }
        return result;
    }
}