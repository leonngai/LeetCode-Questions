tion for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        return helper(head, NULL);
    }
    
    ListNode* helper(ListNode* head, ListNode* newHead) {
        if (head == NULL) {
            return newHead;
        }
        
        ListNode* next = head->next;
        head->next = newHead;
        return helper(next, head);
    }
};
