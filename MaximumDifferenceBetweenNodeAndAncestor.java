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
    1. Perform DFS and at each node find difference between current node and highest/lowest values seen through the path
    2. At each node check to see if difference is greater than global max, if it is then update answer
    3. update the highest and lowest value of each level as we go down the different paths
    4. Return answer
    
    Time Complexity: O(N)
    Space Complexity: O(LogN)
*/
class Solution {
    public int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root.left, root.val, root.val);
        helper(root.right, root.val, root.val);
        return ans;
    }
    
    public void helper(TreeNode node, int highestValue, int lowestValue) {
        if (node == null)
            return;
        
        ans = Math.max(ans, Math.abs(highestValue - node.val));
        ans = Math.max(ans, Math.abs(lowestValue - node.val));

        helper(node.left, Math.max(highestValue, node.val), Math.min(lowestValue, node.val));
        helper(node.right, Math.max(highestValue, node.val), Math.min(lowestValue, node.val));
    }
}
