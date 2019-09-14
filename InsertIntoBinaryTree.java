tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ans = root;
        //empty BST
        if (ans == null) {
            ans = new TreeNode(val);
            return ans;
        }
        
        //existing BST
        else {
            TreeNode newNode = new TreeNode(val);
            boolean traverse = true;
            while (traverse) {
                //traverse right if val is greater
                if (val > root.val && root.right != null) {
                    root = root.right;
                }
                //traverse left if val is smaller
                else if (val < root.val && root.left != null) {
                    root = root.left;
                }
                //insert left
                else if (val > root.val && root.right == null) {
                    root.right = newNode;
                    traverse = false;
                }
                //insert right
                else if (val < root.val && root.left == null) {
                    root.left = newNode;
                    traverse = false;
                }
            }
            return ans;
        }      
    }
}


