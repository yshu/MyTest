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
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    TreeNode construct(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = construct(nums, start, middle-1);
        root.right = construct(nums, middle+1, end);
        return root;
    }
}