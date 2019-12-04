/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return helper(root, root.val);
    }
    
    public boolean helper(TreeNode root, int number) {
        if (root == null)
            return true;
        
        return root.val == number && helper(root.left, number) && helper(root.right, number);
    }
}
