//My Solution

 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int sum;
    
    int rangeSumBST(TreeNode* root, int L, int R) {
        sum = 0;
        helper(root, L, R);
        return sum;
    }
    
    void helper(TreeNode* root, int L, int R) {
        if (root!= NULL) {
            if (L <= root->val && root->val <= R)
                sum += root->val;
            if (root->val > L)
                rangeSumBST(root->left, L, R);
            if (root->val < R)
                rangeSumBST(root->right, L, R);
        }
    }
};
