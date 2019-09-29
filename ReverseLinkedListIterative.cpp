solution for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL) {
            return head;
        }
        
        ListNode* current = head;
        ListNode* currentnext = NULL;
        while(current->next != NULL) {
            currentnext = current->next;
            current->next = currentnext->next;
            currentnext->next = head;
            head = currentnext;
        }
        
        return head;
    
    }
};
