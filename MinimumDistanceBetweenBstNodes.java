/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    Things to do:
    1. Perform in order traversal of tree while keeping track of previous node
    2. Calculate and update the min value accordingly by comparing with current min and current root values minus the previous
    
    Time Complexity: O(N)
    Space Complexity: O(H) where H is the max height of the tree
*/
class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root.left);
        if (prev != null)
            ans = Math.min(ans, root.val - prev.val);
        prev = root;
        dfs(root.right);
    }
}
