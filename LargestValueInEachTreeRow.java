/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        
        if(root == null)
            return answer;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                
                max = Math.max(max, temp.val);
            }
            
            answer.add(max);
        }
        
        return answer;
    }
}
