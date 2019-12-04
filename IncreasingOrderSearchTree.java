/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //In order traversal one pass
    TreeNode answer, previousNode;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return answer;
    }
    
    public void helper(TreeNode root) {
        if(root == null)
            return;
        
        helper(root.left);
        
        if (answer == null) 
            answer = root;
        else
            previousNode.right = root;
        
        previousNode = root;
        root.left = null;
        helper(root.right);
    }
    
    /* In order Traversal using list, 2 pass
    List<TreeNode> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        
        for (int i = 0; i < list.size() - 1; i++) 
            list.get(i).right = list.get(i + 1);
        
        list.get(list.size() - 1).right = null;
        
        return list.get(0);
    }
    
    public void helper(TreeNode root) {
        if(root != null) {
            helper(root.left);
            list.add(root);
            root.left = null;
            helper(root.right);
        }
    }
    */
}
