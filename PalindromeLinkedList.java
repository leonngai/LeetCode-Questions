/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode walker = head, runner = head;
        
        while(runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }
        
        //this means that it is an odd number, move the walker one more to the right so that we are working with the smaller linked list 
        if (runner != null) {
            walker = walker.next;
        }
    
        walker = reverseList(walker);
    
        while(walker != null) {
            if (head.val != walker.val) {
                return false;
            }
            head = head.next;
            walker = walker.next;
            
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode newHead = head;
        
        while(head.next != null)  {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }
        
        return newHead;
    }
}
