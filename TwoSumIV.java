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
    1. Perform a DFS of tree
        1a. Each traversal, add the root.val to our hashset 
    2. Return answer once base case has been reached
    
    Time Complexity: O(N)
    Space Complexity: O(N) for Hashset or O(Height of tree) during recursion
    
    Note - Originally I thought we could use the behaviour of a BST to not have to go through each node in the BST if say the root value was greater than k, then we know we dont need to keep traversing right. However if there are negative numbers like some sample cases have then this algorithm would have a fatal flaw because it would not matter if the root value was greater than k.
    */
    HashSet<Integer> hash = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        
        if (hash.contains(k - root.val))
            return true;
        
        hash.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
