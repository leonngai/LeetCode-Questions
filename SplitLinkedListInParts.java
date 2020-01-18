/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode cursor = root;
        ListNode[] res = new ListNode[k];
        
        while(cursor != null) {
            cursor = cursor.next;
            size++;
        }
        
        cursor = root;
        int extraNodeCount = size % k, minNodeCount = size / k;
        for (int i = 0; i < k && cursor != null; i++, extraNodeCount--) {
            res[i] = cursor;
            for (int j = 0; j < minNodeCount + (extraNodeCount > 0 ? 1 : 0) - 1; j++) {
                cursor = cursor.next;
            }
            
            ListNode temp = cursor;
            cursor = cursor.next;
            temp.next = null;
        }
        return res;
    }
}
