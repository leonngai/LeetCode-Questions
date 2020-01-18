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
    1. Perform post order traversal and keep track of each subtree sum in a hashmap along with its count
    2. When the count for a particular value in hashset is greater than the mode, update mode and add to list
    3. When the count for a particular value is equal to mode, add to list
    3. During post order traversal we will want to return the current node value and its sum
    
    Time Complexity: O(N)
    Space Complexity: O(N)
*/
class Solution {
    int mode = 0;
    Map<Integer, Integer> hash = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        
        postOrder(root);
        
        int[] ans = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
    
    public int postOrder(TreeNode node) {
        if (node == null)
            return 0;
        
        int sum =  postOrder(node.left) + postOrder(node.right) + node.val;
        
        hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        if (hash.get(sum) > mode) {
            mode = hash.get(sum);
            result = new ArrayList<>();
            result.add(sum);
        }
        else if (hash.get(sum) == mode)
            result.add(sum);
        
        return sum;
    }
}
