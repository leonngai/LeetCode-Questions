/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        
        ListNode slow = head, fast = head;
        
        //move fast n nodes ahead of slow pointer
        while(n-- > 0) 
            fast = fast.next;
        
        
        if (fast == null)
            return head.next;
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
