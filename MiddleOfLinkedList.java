tion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        
        //if fast pointer equals null, then we know it is an odd number list
        //if fast pointer.next equals null, then we know it is an even numbe r list
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        if (fastPointer == null)
            return slowPointer;
        
        return slowPointer.next;
    }
}
