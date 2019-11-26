/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode temp = dummyHead;
        ListNode cursor = temp.next;
        
        while(cursor != null) {
            while(cursor != null && cursor.next != null && cursor.val == cursor.next.val) {
                cursor = cursor.next;
            }

            if (temp.next != cursor) {
                cursor = cursor.next;
                temp.next = cursor;
            }
            else {
                temp = cursor;
                cursor = temp.next;
            }
        }
        
        return dummyHead.next;
    }
}
