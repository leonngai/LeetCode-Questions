/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        1. Perform DFS of tree keeping a temporary sum as we go down each level
            1a. With each traversal, multiply the temporary sum by 2 which acts as a left bit shift and add the current roots value
            1b. When the base case has been reached of being a child node, add the temporary sum to our global answer
        2. Return answer
        
        Time Complexity: O(N)
        Space Complexity: O(Height of tree) of recursive stack
    */
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        DFS(root, 0);
        return ans;
    }
    
    public void DFS(TreeNode root, int sum) {
        sum = sum * 2 + root.val;
        
        if (root.left == null && root.right == null)
            ans += sum;
        
        if (root.left != null)
            DFS(root.left, sum);
        if (root.right != null)
            DFS(root.right, sum);
    }
}
