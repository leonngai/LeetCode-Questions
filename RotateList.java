/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
    Process:

*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        
        int size = 0;
        ListNode cursor = head;

        
        while (cursor != null) {
            size++;
            cursor = cursor.next;
        }
        
        if (size <= 1)
            return head;
        
        cursor = head;
        ListNode fast = head;
        k = k % size;
        
        if (k == 0)
            return head;
        
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        
        while(fast.next != null) {
            cursor = cursor.next;
            fast = fast.next;
        }
        
        ListNode newHead = cursor.next;
        cursor.next = null;
        fast.next = head;
        
        return newHead;
        
    }
}
