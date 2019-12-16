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
    public boolean isCousins(TreeNode root, int x, int y) {
        //Initialize the BFS queue and boolean value for if a value is found
        Queue<TreeNode> q = new LinkedList<>();
        boolean foundOne = false;
        
        //Add the root to the BFS; note that there is no need to check if root is null since we are guaranteed a minimum tree size of 2
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            //Search the tree level by level to see if the values that we are looking for are on the next level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if (node.left != null) {
                    //Check to see if the left value is one of the wanted values and that we have not found one yet
                    if ((node.left.val == x || node.left.val == y) && !foundOne) {
                        foundOne = true;
                        
                        //Since found one was false, we immediately check to see if the value on the right has a target value
                        if (node.right != null && (node.right.val == x || node.right.val == y)) {
                            return false;
                        }
                    }
                    
                    //Check to see if we have found the last wanted value since we already have found one
                    else if ((node.left.val == x || node.left.val == y) && foundOne)
                        return true;
                    //Add the left node to the queue to continue our BFS
                    else
                        q.add(node.left);
                }
                
                //Perform similar steps with the right node now
                if (node.right != null) {
                    if ((node.right.val == x || node.right.val == y) && !foundOne)
                        foundOne = true;
                    else if ((node.right.val == x || node.right.val == y) && foundOne)
                        return true;
                    else
                        q.add(node.right);
                }
            }
            
            //If we reach this point but foundOne is true, we know automatically to return false since we only found one of the two values in one level
            if (foundOne)
                return false;
        }
        
        return false;
    }
}
