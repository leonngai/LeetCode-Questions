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
    /*
        1. Perform a in order traversal of both trees
            1a. During the traversal, we want to add these elements to a list so that we get a sorted list of each tree
        2. Apply 2 pointer technique to merge the sorted list of each tree together into one list
        
        Time Complexity: O(N + M)
        Space Complexity: O(N + M)
    
    */
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> answer = new ArrayList<>();
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        dfs(root1, list1);
        dfs(root2, list2);
        
        int index1 = 0, index2 = 0;
        
        while(index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                answer.add(list1.get(index1));
                index1++;
            }
            else {
                answer.add(list2.get(index2));
                index2++;
            }
        }
        
        while(index1 < list1.size()) {
            answer.add(list1.get(index1));
            index1++;
        }
        
        while(index2 < list2.size()) {
            answer.add(list2.get(index2));
            index2++;
        }
        
        return answer;
    }
    
    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
