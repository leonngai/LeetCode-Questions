/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode searchBST(TreeNode root, int val) {
        /* Iterative Solution - Use a TreeNode cursor and traverse through the tree until we either hit null or find the value
        
        Time Complexity: O(N)
        Space Complexity: O(1)
        */
        
        TreeNode cursor = root;
        while(cursor != null && cursor.val != val) {
            if (cursor.val > val)
                cursor = cursor.left;
            else
                cursor = cursor.right;
        }
        
        return cursor;
    }
    
    /* Recursive solution - 2 base cases
    Time Complexity: O(N)
    Space Complexity: O(N)
    1) If we reach null it means that the value is not in our tree
    2) If we find the value, we return the root
    
    In each recursive call we either traverse to the left or right of the node until we reach one of the 2 base cases
    
    public TreeNode searchBST(TreeNode root, int val) {
        //Base case 1
        if (root == null)
            return null;
        //Base case 2
        if (root.val == val)
            return root;
        
        if (root.val > val)
            return searchBST(root.left, val);
        else 
            return searchBST(root.right, val);
    }
    
    */
}
