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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        int val = preorder[0];
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
            int[] newpreorder = Arrays.copyOfRange(preorder, 1, index+1);
            root.left = buildTree(newpreorder, newinorder);
        }
        if(index != inorder.length-1) {
            int[] newinorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
            int[] newpreorder = Arrays.copyOfRange(preorder, index+1, preorder.length);
            root.right = buildTree(newpreorder, newinorder);
        }
        
        return root;
    }
}