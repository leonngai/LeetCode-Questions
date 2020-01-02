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
        1. Traverse the tree and look for nodes that have values < L or values > R
            1a. If value < L, we cut off everything to the left of this and return the node to the right of this (Why? Because this is a BST, all nodes to the left of this current node will automatically be disqualified as well as their values will be smaller)
            1b. Similarly if value > R, we cut off everything to the right and only return the node to the left
        2. Recursively set the left and right pointer of the current node to either the current left and right pointer, or the correct node based off conditions 1a and 1b described above
        
        Time Complexity: O(N)
        Space Complexity: O(Height of tree)
    
    */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        //base case
        if (root == null)
            return null;
        
        if (root.val < L)
            return trimBST(root.right, L, R);
        if (root.val > R)
            return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
}
