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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();
        if (root == null)
            return answer;
        
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode temp = stack.pop();
                answer.add(temp.val);
                root = temp.right;
            }
        }
        
        
        
        return answer;
    }
    
    
}
