/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        
        while(fast.next != null) {
            slow.val = fast.val;
            slow = slow.next;
            fast = fast.next;
        }
        slow.val = fast.val;
        slow.next = null;
    }
}
