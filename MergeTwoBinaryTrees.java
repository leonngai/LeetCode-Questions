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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        
        //t1 is null meaning we can just return t2
        if (t1 == null)
            return t2;
        //t2 is null meaning we can just return t1
        if (t2 == null)
            return t1;
        
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
    
/*
    - Creating a node with each pass
        TreeNode root = null;
        
        if (t1 == null && t2 == null)
            return root;
        
        //meaning t2 not null
        else if (t1 == null) {
            root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        }
        
        //meaning t1 not null
        else if (t2 == null) {
            root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }
        
        else{
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        
        return root;
*/
