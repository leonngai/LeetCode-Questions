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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < q.val ? helper(root, p.val, q.val) : helper(root, q.val, p.val);
    }
    
    public TreeNode helper(TreeNode node, int smaller, int larger) {
        if (node == null)
            return null;
        
        if (smaller <= node.val && node.val <= larger)
            return node;
        else if (node.val < smaller && node.val < larger)
            return helper(node.right, smaller, larger);
        else
            return helper(node.left, smaller, larger);
    }
}
