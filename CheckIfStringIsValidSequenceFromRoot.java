/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);   
    }
    
    public boolean helper(TreeNode node, int[] arr, int index) {
        if (node == null || index >= arr.length || arr[index] != node.val)
            return false;
        else if (node.left == null && node.right == null && arr[index] == node.val && index == arr.length - 1)
            return true;
        
        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }
}
