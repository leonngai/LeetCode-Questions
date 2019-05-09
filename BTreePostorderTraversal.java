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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> answer = new LinkedList<>();
        if (root == null)
            return answer;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                answer.addFirst(root.val);
                root = root.right;
            }
            else {
                TreeNode temp = stack.pop();
                root = temp.left;
            }
        }
        
        return answer;
    }
}
