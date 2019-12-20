/* Definittion for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*Logic behind this problem...
    If there is a cycle, the runner and walker must meet before the runner runs into a null. So if the runner runs into a null, we return null. Second we can think of the problem as such... the walker travels at a pace of K nodes while the runner travels at a pace of 2K nodes. So if the the cycle starts after K nodes, then we know that by the time the walker reaches the beginning of the cycle the runner has already travelled K nodes into the cycle (Why? Because the runner has travelled 2K nodes - K nodes. Next we figure out when these two pointers meet. Well the runner is Loop size - K nodes behind the walker and hence will catch up to the walker in Loop size - K turns. So when they finally do meet, the pointers will be Loop size - K turns into the loop or K turns behind the start of the loop. We do not know what K is however but we do know that it took K turns to reach the start of the loop from the head. So starting from the head we can advance another pointer until the walker and head pointer are equal.)
    */
    public ListNode detectCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        
        while(runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            
            if (runner == walker) {
                while(walker != head) {
                    head = head.next;
                    walker = walker.next;
                }
                
                return head;
            }
        }
        
        return null;
    }
}
