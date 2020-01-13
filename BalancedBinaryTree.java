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
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    
    public int helper(TreeNode node) {
        //base case of if node is null then return height of 0
        if (node == null)
            return 0;
        
        //get height of left tree and check to see if its balanced on the right side
        int left = helper(node.left);
        if (left == -1)
            return -1;
        
        //get height of right tree and check to see if its balanced on the right side
        int right = helper(node.right);
        if (right == -1)
            return -1;
        
        //check if current node is balanced by subtracting the right height from left height
        if (Math.abs(left - right) > 1)
            return -1;
        
        //return the taller height of left and right subtree and add 1 as we go up another level
        return Math.max(left, right) + 1;
    }
}
