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
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
    
    public int helper(TreeNode current, int sum) {
        if (current == null)
            return sum;
        
        current.val += helper(current.right, sum);
        sum = current.val;
        sum = helper(current.left, sum);
        return sum;
    }
}
