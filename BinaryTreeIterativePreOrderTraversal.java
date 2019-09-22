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
    List<Integer> list = new LinkedList<>();
    
    
    public List<Integer> preorderTraversal(TreeNode root) {  
        Stack<TreeNode> stack= new Stack<>();
        
        while(root != null) {
            list.add(root.val);
            
            if (root.right != null) {
                stack.push(root.right);
            }
            
            root = root.left;
            
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        
        
        return list;
    }


}
