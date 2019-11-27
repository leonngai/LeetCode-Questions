tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;
        
        if(root == null)
            return answer;
        
        q.add(root);
        
        while(!q.isEmpty()) {
            int queueSize = q.size();
            List<Integer> tempList = new ArrayList<>();
            
            for (int i = 0; i < queueSize; i++) {
                TreeNode temp = q.poll();
                
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                
                if(leftToRight)
                    tempList.add(temp.val);
                else
                    tempList.add(0, temp.val);
            }
            
            answer.add(tempList);
            leftToRight = leftToRight ? false : true;
        }
        
        return answer;
    }
}
