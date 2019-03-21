/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode answer = null;
        int carry = 0;
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            
            temp.next = answer;
            answer = temp;
        }
        
        while(!s1.isEmpty()) {
            int sum = s1.pop() + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            
            temp.next = answer;
            answer = temp;
        }
        
        while(!s2.isEmpty()) {
            int sum = s2.pop() + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            
            temp.next = answer;
            answer = temp;
        }
        
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = answer;
            answer = temp;
        }
        
        return answer;
        
    }
}
