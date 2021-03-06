/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        ListNode head = l1.val <= l2.val ? l1 : l2;
        while(l1 != null && l2 != null) {
            ListNode temp;
            if (l1.val <= l2.val) {
                if (l1.next != null && l1.next.val <= l2.val) {
                    l1 = l1.next;
                    continue;
                }
                temp = l1.next;
                l1.next = l2;
                l1 = temp;
            }
            else {
                if(l2.next != null && l2.next.val < l1.val) {
                    l2 = l2.next;
                    continue;
                }
                temp = l2.next;
                l2.next = l1;
                l2 = temp;
            }
        }
        
        return head;
    }
}
