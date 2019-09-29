tion for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        return helper(root, 0, INT_MIN);
    }
    
    int helper(TreeNode* root, int count, int max) {
        if (root == NULL) {
            return count > max ? count : max;
        }
        
        int leftcount = helper(root->left, count + 1, max);
        int rightcount = helper(root->right, count + 1, max);
        
        return leftcount > rightcount ? leftcount : rightcount;
    }
};
