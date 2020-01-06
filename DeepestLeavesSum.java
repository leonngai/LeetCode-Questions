/** 
 * Definittion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        Things to do:
            1. Perform BFS
            2. For each level, keep a temporary sum of all the values
            3. After each level, check if what we just went through was the deepest level
                - If it was deepest level -> set the answer to our sum that we just calculated
                - If it was not deepest level -> continue on with the BFS
            4. Return answer
    
        Time Complexity: O(N)
        Space Complexity: O(W) where W represents the max width of our tree
    */
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // 1. Perform BFS
        while(!q.isEmpty()) {
            int size = q.size();
            int tempAns = 0;
            
            // 2. Keep a temporary sum of all values in each level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                tempAns += node.val;
                
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            
            // 3. Check if what we checked was just the deepest level
            if (q.isEmpty())
                ans = tempAns;
        }
        
        // 4. Return answer
        return ans;
    }
}
