/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    Process:
    1. Perform an in order traversal through the tree while keeping track of the previous node visited
    2. Compare the previous node visited with the current node to continuously update your count
    3. If it any point the count is equal to the mode then we add that number to our list
    4. If the count becomes bigger than our mode, then we update our mode and create a brand new list
    5. Copy the elements from the list after traversal into our resultant array and return

    Time Complexity: O(N)
    Space Complexity: O(1) if we don't count the arraylist as extra space since we use it for our answer, O(N) if we do count it
*/
class Solution {
    List<Integer> list = new ArrayList<>();
    int mode = 1, count = 1;
    TreeNode prev = null;
    
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        
        dfs(root);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    public void dfs(TreeNode root) {
        if (root == null)
            return;
        
        dfs(root.left);
        
        if (prev != null) {
            if (prev.val == root.val) {
                count++;
            }
            else {
                count = 1;
            }
        }
                        
        if (count > mode) {
            mode = count;
            list = new ArrayList<>();
            list.add(root.val);
        }
        else if (count == mode) {
            list.add(root.val);
        }
        prev = root;
        dfs(root.right);
    }
}
