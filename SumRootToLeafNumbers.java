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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return ans;
        
        helper(root, 0);
        return ans;
    }
    
    public void helper(TreeNode node, int sum) {
        sum = sum * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            ans += sum;
            return;
        }
        
        if (node.left != null)
            helper(node.left, sum);
        
        if (node.right != null)
            helper(node.right, sum);
    }
}
