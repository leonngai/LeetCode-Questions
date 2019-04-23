/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cursor = head;
        while(cursor!= null) {
            stack.push(cursor);
            cursor = cursor.next;
        }
        if (stack.isEmpty()) {
            return head;
        }
        ListNode newhead = stack.pop();
        ListNode ref = newhead;
        while(!stack.isEmpty()) {
            newhead.next = stack.pop();
            newhead = newhead.next;
           
        }
        
        newhead.next = null;
        return ref;
    }
    
}
