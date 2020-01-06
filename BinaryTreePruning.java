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
    /*
        1. Perform a DFS with bottom up approach
            Things to keep in mind:
            1a. base case: if the root == null
            1b. if left/right child has no subtree with 1 -> delete
            1c. if left/right child has subtree of 1 -> return true
        2. Return root
        
        Time Complexity: O(N)
        Space Complexity: O(H)
    */
    public TreeNode pruneTree(TreeNode root) {
        boolean keep = helper(root);
        return keep ? root : null;
    }
    
    public boolean helper(TreeNode root) {
        if (root == null)
            return false;
        
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        if (!left)
            root.left = null;
        if (!right)
            root.right = null;
        
        return left || right || root.val == 1;
    }
}
