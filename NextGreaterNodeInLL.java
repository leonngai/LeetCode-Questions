/**
 * Definittion for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        Process:
        1. Go through the linked list adding every element to an arraylist
        2. Iterate through the array
            2a. At each element compare the current value with whats in the stack
            2b. If current value > number at index stored in stack, pop() and set arr[index] = current value
            2c. If not, ignore and push index to stack
        3. Return result
        
        Time Complexity: O(N)
        Space Complexity: O(N)
    */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            int currentValue = list.get(i);
            while(!stack.isEmpty() && list.get(stack.peek()) < currentValue) {
                int indexToInsert = stack.pop();
                result[indexToInsert] = currentValue;
            }
            stack.push(i);
        }
        
        return result;
    }
}
