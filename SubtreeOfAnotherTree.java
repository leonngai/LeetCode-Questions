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
    Process:
    1. Use a helper function that checks if two trees are the same given just the root
    2. Use the main function to call that helper function to first check if the two trees are equal first using the s.root value
    3. Keep checking and calling the helper function by traversing down the s tree until we have either hit a true or if we have checked all nodes
    
    Time Complexity: O(S)
    Space Complexity: O(LogT)
*/
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
