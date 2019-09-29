solution for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0, Integer.MIN_VALUE);
    }
    
    public int helper(TreeNode root, int count, int max) {
        if (root == null) {
            return Integer.max(count, max);
        }
        
        int leftcount = helper(root.left, count + 1, max);
        int rightcount = helper(root.right, count + 1, max);
        
        return Integer.max(leftcount, rightcount);
    }
}
