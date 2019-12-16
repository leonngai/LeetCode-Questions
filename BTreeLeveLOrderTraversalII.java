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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        
        if (root != null)
            q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
                
                temp.add(n.val);
            }
            
            list.add(0, new ArrayList<>(temp));
        }
        
        return list;
    }
}
