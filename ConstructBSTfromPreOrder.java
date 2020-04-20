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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for (int i = 1; i < preorder.length; i++)
            insert(root, preorder[i]);
        
        return root;
    }
    
    public void insert(TreeNode node, int value) {
        if (value < node.val && node.left == null)
            node.left = new TreeNode(value);
        else if (value < node.val)
            insert(node.left, value);
        else if (value > node.val && node.right == null)
            node.right = new TreeNode(value);
        else
            insert(node.right, value);    
    }
}
