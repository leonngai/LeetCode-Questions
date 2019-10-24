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
    - To be symmetric, the right and left side of each node has to be the same

*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode Left, TreeNode Right) {
        if ((Left == null && Right != null) || (Left != null && Right == null)) {
            return false;
        }
        else if (Left == null && Right == null) {
            return true;
        }
        
        return Left.val == Right.val && helper(Left.left, Right.right) && helper(Left.right, Right.left);
        
    }
}
