tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        ListNode tempHead = head;
        ListNode walker = tempHead.next;
        while(tempHead != null) {
            while(walker != null && walker.val == tempHead.val) {
                walker = walker.next;
            }

            tempHead.next = walker;
            tempHead = walker;

        }

        return head;
    }
}
