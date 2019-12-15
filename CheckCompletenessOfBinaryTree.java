/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        boolean isLast = false;
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                
                if (temp.left != null && isLast)
                    return false;
                else if (temp.left != null && !isLast)
                    q.add(temp.left);
                else 
                    isLast = true;
                
                if (temp.right != null && isLast) 
                    return false;
                else if (temp.right != null && !isLast)
                    q.add(temp.right);
                else
                    isLast = true;
            }
        }
        
        return true;
    }
}
