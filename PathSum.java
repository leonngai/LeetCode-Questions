/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }
    
    public boolean helper(TreeNode node, int sum) {
        if (node == null)
            return false;
        
        if (node.left == null && node.right == null && node.val == sum)
            return true;
        
        return helper(node.left, sum - node.val) || helper(node.right, sum - node.val);
    }
}
