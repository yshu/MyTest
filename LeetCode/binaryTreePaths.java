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
    ArrayList<String> paths = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, "");
        return paths;
    }

    void traverse(TreeNode root, String s) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            //this is root
            s = s + root.val;
            paths.add(s);
        }
        else {
            s = s + root.val + "->";
        }
        if(root.left != null) traverse(root.left, s);
        if(root.right != null) traverse(root.right, s);
    }
}