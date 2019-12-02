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
    public int findBottomLeftValue(TreeNode root) {
        TreeNode answer = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            answer = q.poll();
        
            if(answer.right != null)
                q.add(answer.right);
            if (answer.left != null)
                q.add(answer.left);
        }
        
        
        return answer.val;
    }
}
