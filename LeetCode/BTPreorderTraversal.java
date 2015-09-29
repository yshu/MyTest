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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);        
        TreeNode current = null;
        while(current != null || !stack.isEmpty()) {
            if(current == null) {
                current = stack.pop();
            }
            result.add(current.val);                        

            if(current.right != null) stack.push(current.right);
            current = current.left;
        }

        return result;
    }
}