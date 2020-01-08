/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
	Process and things to remember:
	1.  Have a cursor that goes through each node to see if they belong in the first list or second list
	2. If node belongs in the first/second list and is the first element, we will set this as the first/second lists head and tail
	3. If node belongs in the first/second list and is not the first element, we will move the tail of the first/second list to point to this current node and set it as our new tail
	4. Set our first lists tail to point to our second lists head
	5. Set our second lists tail to null
	6. Return the first lists head if it exists; return second lists head if it does not

	Time Complexity: O(N) to go through all nodes in the list once
	Space Complexity: O(1) space used is not dependent on the input size
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cursor = head;
        ListNode smallHead = null, smallTail = null;
        ListNode bigHead = null, bigTail = null;
        
        // Step 1
        while(cursor != null) {
            if(cursor.val < x) {
                //Step 2
                if (smallHead == null) {
                    smallHead = cursor;
                    smallTail = cursor;
                }
                //Step 3
                else {
                    smallTail.next = cursor;
                    smallTail = cursor;
                }
            }
            else {
                //Step 2
                if (bigHead == null) {
                    bigHead = cursor;
                    bigTail = cursor;
                }
                //Step 3
                else {
                    bigTail.next = cursor;
                    bigTail = cursor;
                }
            }
            
            cursor = cursor.next;
        }
        
        //Step 4
        if (smallTail != null)
            smallTail.next = bigHead;
        //Step 5
        if (bigTail != null)
            bigTail.next = null;
        
        //Step 6
        return smallHead == null ? bigHead : smallHead;
    }
}
