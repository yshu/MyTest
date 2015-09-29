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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;

        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);

        int index = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) {
                index = i;
                break;
            }
        }

        if(index != 0) {
            int[] newinorder = Arrays.copyOfRange(inorder, 0, index);
            int[] newpostorder = Arrays.copyOfRange(postorder, 0, index);
            root.left = buildTree(newinorder, newpostorder);
        }
        if(index != inorder.length-1) {
            int[] newinorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
            int[] newpostorder = Arrays.copyOfRange(postorder, index, inorder.length-1);
            root.right = buildTree(newinorder, newpostorder);
        }
        
        return root;
    }
}