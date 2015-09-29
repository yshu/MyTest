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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
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

            if(current.left != null) stack.push(current.left);
            current = current.right;
        }
        Collections.reverse(result);

        return result;
    }
}

public class Solution2 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = null;
        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            current = stack.pop();
            if((current.left==null&&current.right==null) || (current.right!=null&&current.right==prev) || (current.right==null&&current.left==prev)) {
                result.add(current.val);
                prev = current;
            }
            else if(current.left==null || (current.left==prev&&current.right!=null)) {
                stack.push(current);
                stack.push(current.right);
            }
            else {
                stack.push(current);
                stack.push(current.left);
            }

        }

        return result;
        
    }
}