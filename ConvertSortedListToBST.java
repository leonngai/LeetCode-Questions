/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        return helper(list, 0, list.size() - 1);
    }
    
    public TreeNode helper(List<Integer> list, int lower, int upper) {
        if (lower > upper)
            return null;
        
        int middle = lower + (upper - lower) / 2;
        TreeNode newNode = new TreeNode(list.get(middle));
        newNode.left = helper(list, lower, middle - 1);
        newNode.right = helper(list, middle + 1, upper);
        
        return newNode;
    }
}
