
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    
    public TreeNode helper(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        
        int index = maxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        
        root.left = helper(nums, l, index);
        root.right= helper(nums, index + 1, r);
            
        return root;
    }
    
    public int maxIndex(int[] nums, int l, int r) {
        int maxIndex = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
}

/*
find the index of the highest number in array
then find index of highest number left and right of that index
repeat
*/
