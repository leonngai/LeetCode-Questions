solution for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode current = head;
        ListNode currentnext = null;
        while(current.next != null) {
            currentnext = current.next;
            current.next = currentnext.next;
            currentnext.next = head;
            head = currentnext;
        }
        
        return head;
    }
}
