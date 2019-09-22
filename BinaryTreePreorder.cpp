tion for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

#include <iostream> 
#include <stack> 

class Solution {
public:
    
    vector<int> list;
    
    
    vector<int> preorderTraversal(TreeNode* root) {  
        stack<TreeNode*> stack;
        
        while(root != NULL) {
            list.push_back(root->val);
            
            if (root->right != NULL) {
                stack.push(root->right);
            }
            
            root = root->left;
            
            if (root == NULL && !stack.empty()) {
                root = stack.top();
                stack.pop();
            }
        }
        
        
        return list;
    }
};
