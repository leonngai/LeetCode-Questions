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
    1. Perform DFS of the tree and check if the current node checked is even
    2. If the current node checked is even then we will look for the grandchildren and add the values of those grandchildren to the answer
    3. Then traverse left and right
    
    Time Complexity: O(N)
    Space Complexity: O(Height of Tree)
*/
class Solution {
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    public void dfs(TreeNode node) {
        if (node == null)
            return;
        
        //if even, then grab the nodes needed and perform the calculation
        if (node.val % 2 == 0) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            
            if (left != null) {
                if (left.left != null)
                    ans += left.left.val;
                if (left.right != null)
                    ans += left.right.val;
            }
            
            if (right != null) {
                if (right.left != null)
                    ans += right.left.val;
                if (right.right != null)
                    ans += right.right.val;
            }
        }
        
        dfs(node.left);
        dfs(node.right);
    }
}
