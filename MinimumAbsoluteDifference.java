/* Definittion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Optimized
        1. Perform an in order traversal of the nodes and keep track of the previous node visited
        2. Subtract the current nodes value with previous node
        3. Return the smallest difference
    */
    TreeNode prev = null;
    int answer = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return answer;  
    }
    
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root.left);
        
        if (prev != null)
            answer = Math.min(answer, root.val - prev.val);
        
        prev = root;
        dfs(root.right);
    }
    
        /*
    Not optimized - The bottleneck here is that we have to perform the calculation of the minimum difference after having already traversed the tree. If we can calculate the minimum difference at the same time that we traverse the tree then we can really optimize this algorithm.
    
        1. Traverse the nodes and add each node into a list; since this is a BST if we use a in-order 
        2. Subtract each number from each other going down the list
        3. Return the smallest difference
    
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        
        int answer = Integer.MAX_VALUE;
        for(int i = list.size() - 1; i >= 1; i--) {
            if (list.get(i) - list.get(i - 1) < answer)
                answer = list.get(i) - list.get(i - 1);
        }
        
        return answer;  
    }
    
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    */
}
