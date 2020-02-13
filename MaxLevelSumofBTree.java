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
    public int maxLevelSum(TreeNode root) {
        int ans = 1, level = 1;
        int max = Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                
                sum += temp.val;
                
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            
            if (sum > max) {
                ans = level;
                max = sum;
            }
            
            level++;
        }
        
        return ans;
    }
}
